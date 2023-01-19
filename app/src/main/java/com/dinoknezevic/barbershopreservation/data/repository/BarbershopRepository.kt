package com.dinoknezevic.barbershopreservation.data.repository

import com.dinoknezevic.barbershopreservation.model.Service
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface BarbershopRepository {
    fun services(): Flow<List<Service>>
    fun timeSlots(currentDate: Long):Flow<List<TimeSlot>>

    fun timeSlotsHistory(userId: String) :Flow<List<TimeSlot>>

    suspend fun generateServices()

    suspend fun bookTimeSlot(timeSlot: TimeSlot)
    suspend fun fetchTimeSlotsForCurrentDay(currentDate: Long): Flow<List<TimeSlot>>

    suspend fun deleteTimeSlot(timeSlotId:Int)
}
