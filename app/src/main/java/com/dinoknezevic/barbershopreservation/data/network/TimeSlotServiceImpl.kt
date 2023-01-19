package com.dinoknezevic.barbershopreservation.data.network

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.dinoknezevic.barbershopreservation.data.network.model.TimeSlotResponse
import com.dinoknezevic.barbershopreservation.mock.BarberMock
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.security.SecureRandom


class TimeSlotServiceImpl(
    private val bgDispatcher: CoroutineDispatcher
) : TimeSlotService {

    @RequiresApi(Build.VERSION_CODES.O)
    private val timeSlotsForCalculations = BarberMock.getTimeSlotsForCalculations()

    private val databaseFirebase = FirebaseFirestore.getInstance()
    private val collectionPath = "timeslots"
    private val timeSlotsRef = databaseFirebase.collection(collectionPath)

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun fetchTimeSlots(slotDate: Long): TimeSlotResponse {
        val comparedTimeSlotsList = timeSlotsForCalculations
        val randomValue = SecureRandom()
        val timeSlotsSnapshot = timeSlotsRef.get().await()
        val timeSlotsList = mutableListOf<TimeSlot>()
        timeSlotsSnapshot.forEach { document ->
            val timeSlotId = document.get("timeSlotId") as Long
            val userId = document.get("userId") as String
            val date = document.get("date") as Long
            val isAvailable = document.get("isAvailable") as Boolean
            val startTime = document.get("startTime") as String
            val endTime = document.get("endTime") as String
            val name = document.get("name") as String
            val timeSlot = TimeSlot(
                timeSlotId.toInt(),
                userId,
                date,
                isAvailable!!,
                startTime,
                endTime,
                name
            )
            if (timeSlot.date == slotDate && !timeSlot.isAvailable) {
                timeSlotsList.add(timeSlot)
            }
        }
        val availableTimeSlots = comparedTimeSlotsList.filterNot {
            timeSlotsList.any { unavailableSlot ->
                it.startTime == unavailableSlot.startTime && it.endTime == unavailableSlot.endTime
            }
        }
        for (slot in availableTimeSlots){
            slot.timeSlotId = randomValue.nextInt()
        }
        return TimeSlotResponse(availableTimeSlots)
    }

    override suspend fun cancelTimeSlot(timeslotId: Int) {
        timeSlotsRef.document(timeslotId.toString()).delete()
    }

    override suspend fun insertTimeSlot(timeSlot: TimeSlot) {
        withContext(bgDispatcher) {
            //val adjustedTimeSlot =
            timeSlotsRef.document(timeSlot.timeSlotId.toString()).set(timeSlot)
        }
    }

    override suspend fun fetchUserTimeSlots(userId: String): TimeSlotResponse {
        val timeSlotsSnapshot = timeSlotsRef.get().await()
        val timeSlotsList = mutableListOf<TimeSlot>()
        timeSlotsSnapshot.forEach { document ->
            val timeSlotId = document.get("timeSlotId") as Long
            val userId1 = document.get("userId") as String
            val date = document.get("date") as Long
            val isAvailable = document.get("isAvailable") as Boolean
            val startTime = document.get("startTime") as String
            val endTime = document.get("endTime") as String
            val name = document.get("name") as String
            val timeSlot = TimeSlot(
                timeSlotId.toInt(),
                userId1,
                date,
                isAvailable!!,
                startTime,
                endTime,
                name
            )
            if (
                userId1 == userId
            ) {
                timeSlotsList.add(timeSlot)
            }
        }
        return TimeSlotResponse(timeSlotsList)
    }



}
