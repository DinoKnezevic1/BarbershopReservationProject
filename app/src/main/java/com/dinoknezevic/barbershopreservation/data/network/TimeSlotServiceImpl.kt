package com.dinoknezevic.barbershopreservation.data.network

import com.dinoknezevic.barbershopreservation.data.network.model.TimeSlotResponse
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class TimeSlotServiceImpl(
    private val bgDispatcher: CoroutineDispatcher
) : TimeSlotService {

    private val databaseFirebase = FirebaseFirestore.getInstance()
    private val collectionPath = "timeslots"
    private val timeSlotsRef = databaseFirebase.collection(collectionPath)

    override suspend fun fetchTimeSlots(slotDate: Long): TimeSlotResponse {
        val timeSlotsSnapshot = timeSlotsRef.get().await()
        val timeSlotsList = mutableListOf<TimeSlot>()
        timeSlotsSnapshot.forEach { document ->
            val timeSlotId = document.get("timeSlotId") as Long
            val userId = document.get("userId") as Long
            val date = document.get("date") as Long
            val isAvailable = document.getBoolean("isAvailable")
            val startTime = document.get("startTime") as String
            val endTime = document.get("endTime") as String
            val name = document.get("name") as String
            val timeSlot = TimeSlot(
                timeSlotId.toInt(),
                userId.toInt(),
                date.toLong(),
                isAvailable,
                startTime,
                endTime,
                name
            )
            if (timeSlot.date==slotDate)
            {
            timeSlotsList.add(timeSlot)
            }
        }
        return TimeSlotResponse(timeSlotsList)
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

}
