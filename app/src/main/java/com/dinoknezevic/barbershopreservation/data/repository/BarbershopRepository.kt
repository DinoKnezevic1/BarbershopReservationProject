package com.dinoknezevic.barbershopreservation.data.repository

import com.dinoknezevic.barbershopreservation.model.Service
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface BarbershopRepository {
    fun services(): Flow<List<Service>> // retrieve list of services for reservations screen
    fun timeSlots(): Flow<List<TimeSlot>>
    fun setDate(currentDate: Long)
    //first network call if device online, only for history timeslots offline call
    suspend fun generateServices()
    //fun reservations(): Flow<List<ReservationDetails>> // retrieve list of services for history screen
    suspend fun bookTimeSlot(timeSlot: TimeSlot)
    suspend fun fetchTimeSlotsForCurrentDay(currentDate: Long): Flow<List<TimeSlot>>
    //suspend fun makeReservation(reservationDetails: ReservationDetails)
    //suspend fun removeReservation(reservationId: String)
}
