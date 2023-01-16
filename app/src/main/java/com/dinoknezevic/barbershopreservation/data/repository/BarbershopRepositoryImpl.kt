@file:OptIn(ExperimentalCoroutinesApi::class)

package com.dinoknezevic.barbershopreservation.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.dinoknezevic.barbershopreservation.ContextProvider
import com.dinoknezevic.barbershopreservation.data.database.DbService
import com.dinoknezevic.barbershopreservation.data.database.DbTimeSlot
import com.dinoknezevic.barbershopreservation.data.database.ServiceDao
import com.dinoknezevic.barbershopreservation.data.database.TimeSlotDao
import com.dinoknezevic.barbershopreservation.data.network.BarberService
import com.dinoknezevic.barbershopreservation.data.network.TimeSlotService
import com.dinoknezevic.barbershopreservation.mock.BarberMock.getServices
import com.dinoknezevic.barbershopreservation.model.Service
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class BarbershopRepositoryImpl(
    private val barberService: BarberService,
    private val serviceDao: ServiceDao,
    private val timeSlotDao: TimeSlotDao,
    private val timeSlotService: TimeSlotService,
    private val bgDispatcher: CoroutineDispatcher,
    private val dbFirebase: FirebaseFirestore,
) : BarbershopRepository {

    var pickedDate:Long = 1

    override fun setDate(currentDate: Long){
        pickedDate=currentDate
    }


    suspend fun checkInternet(): Boolean {
        val applicationContext = ContextProvider.getContext()
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    private val servicesList = flow<List<Service>> {
        if (checkInternet()) {
            val response = this@BarbershopRepositoryImpl.barberService.fetchServices()
            emit(response.services as List<Service>)
            serviceDao.insertServices(
                response.services.map {
                    DbService(
                        serviceId = it.serviceId,
                        type = it.type,
                        name = it.name,
                        description = it.description,
                        price = it.price
                    )
                }
            )
        } else {
            val response = serviceDao.services().map { dbServicesList ->
                dbServicesList.map { dbService ->
                    Service(
                        serviceId = dbService.serviceId,
                        type = dbService.type,
                        name = dbService.name,
                        description = dbService.description,
                        price = dbService.price
                    )
                }
            }
            emit(response.first())
        }
    }.shareIn(
        scope = CoroutineScope(bgDispatcher),
        started = SharingStarted.WhileSubscribed(1000L),
        replay = 1,
    )


    override fun services(): Flow<List<Service>> = servicesList

    private val timeSlotsList = flow<List<TimeSlot>> {
        if (checkInternet()) {
            val response = this@BarbershopRepositoryImpl.timeSlotService.fetchTimeSlots(pickedDate)
            emit(response.timeSlots as List<TimeSlot>)
            response.timeSlots.forEach {
                timeSlotDao.insertTimeSlot(
                    DbTimeSlot(
                        timeSlotId = it.timeSlotId,
                        userId = it.userId,
                        date = it.date,
                        isAvailable = it.isAvailable!!,
                        startTime = it.startTime,
                        endTime = it.endTime,
                        name =it.name,
                    )
                )
            }
        } else {
            val response = timeSlotDao.timeSlots(pickedDate).map { dbTimeSlots->
                dbTimeSlots.map {
                    TimeSlot(
                        timeSlotId = it.timeSlotId,
                        userId = it.userId!!,
                        date = it.date,
                        isAvailable = true,
                        startTime = it.startTime,
                        endTime = it.endTime,
                        name =it.name,
                    )
                }
            }
            emit(response.first())
        }
    }.shareIn(
        scope = CoroutineScope(bgDispatcher),
        started = SharingStarted.WhileSubscribed(1000L),
        replay = 1,
    )

    override fun timeSlots(): Flow<List<TimeSlot>> = timeSlotsList

    private fun List<Service>.toDbServices(): List<DbService> {
        return map {
            DbService(
                serviceId = it.serviceId,
                type = it.type,
                name = it.name,
                description = it.description,
                price = it.price
            )
        }
    }


    //initial launch
    private val services = getServices()
    private val servicesFirebase = services.toSet()
    private val serviceEntities = services.toDbServices()

    override suspend fun generateServices() {
        for (service in servicesFirebase) {
            dbFirebase.collection("services").document(service.serviceId.toString())
                .set(service)
        }
        serviceDao.insertServices(serviceEntities)
    }

    override suspend fun bookTimeSlot(timeSlot: TimeSlot) {
        timeSlotService.insertTimeSlot(timeSlot)
        timeSlotDao.insertTimeSlot(
            DbTimeSlot(
                timeSlotId = timeSlot.timeSlotId,
                userId = timeSlot.userId,
                date = timeSlot.date,
                isAvailable = timeSlot.isAvailable!!,
                startTime = timeSlot.startTime,
                endTime = timeSlot.endTime,
                name =timeSlot.name,
            )
        )
    }

    override suspend fun fetchTimeSlotsForCurrentDay(currentDate: Long): Flow<List<TimeSlot>> {
         val timeSlotsList = flow<List<TimeSlot>> {
            if (checkInternet()) {
                val response = this@BarbershopRepositoryImpl.timeSlotService.fetchTimeSlots(currentDate)
                emit(response.timeSlots as List<TimeSlot>)
                response.timeSlots.forEach {
                    timeSlotDao.insertTimeSlot(
                        DbTimeSlot(
                            timeSlotId = it.timeSlotId,
                            userId = it.userId,
                            date = it.date,
                            isAvailable = it.isAvailable!!,
                            startTime = it.startTime,
                            endTime = it.endTime,
                            name =it.name,
                        )
                    )
                }
            } else {
                val response = timeSlotDao.timeSlots(currentDate).map { dbTimeSlots->
                    dbTimeSlots.map {
                        TimeSlot(
                            timeSlotId = it.timeSlotId,
                            userId = it.userId!!,
                            date = it.date,
                            isAvailable = true,
                            startTime = it.startTime,
                            endTime = it.endTime,
                            name =it.name,
                        )
                    }
                }
                emit(response.first())
            }
        }.shareIn(
            scope = CoroutineScope(bgDispatcher),
            started = SharingStarted.WhileSubscribed(1000L),
            replay = 1,
        )
        return timeSlotsList
    }

}
