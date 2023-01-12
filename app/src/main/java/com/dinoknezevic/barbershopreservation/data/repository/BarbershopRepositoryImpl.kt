package com.dinoknezevic.barbershopreservation.data.repository

import com.dinoknezevic.barbershopreservation.data.database.ReservationDao
import com.dinoknezevic.barbershopreservation.data.database.ServiceDao
import com.dinoknezevic.barbershopreservation.data.network.BarberService
import com.dinoknezevic.barbershopreservation.data.network.ReservationService
import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import com.dinoknezevic.barbershopreservation.model.Service
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class BarbershopRepositoryImpl(
    private val barberService: BarberService,
    private val serviceDao: ServiceDao,
    private val reservationService: ReservationService,
    private val reservationDao: ReservationDao,
    private val bgDispatcher: CoroutineDispatcher
):BarbershopRepository {
    override fun services(): Flow<List<Service>> {
        TODO("Not yet implemented")
    }

    override fun reservations(): Flow<List<ReservationDetails>> {
        TODO("Not yet implemented")
    }

    override suspend fun makeReservation(reservationDetails: ReservationDetails) {
        TODO("Not yet implemented")
    }

    override suspend fun removeReservation(reservationId: String) {
        TODO("Not yet implemented")
    }
}