package com.dinoknezevic.barbershopreservation.data.network

import com.dinoknezevic.barbershopreservation.data.database.DbTimeSlot
import com.dinoknezevic.barbershopreservation.data.network.model.TimeSlotResponse
import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import com.dinoknezevic.barbershopreservation.model.TimeSlot

interface TimeSlotService {
    suspend fun fetchTimeSlots(slotDate:Long): TimeSlotResponse

    suspend fun cancelTimeSlot(timeslotId: Int)

    suspend fun insertTimeSlot(timeSlot: TimeSlot)//maybe java.utill class(firestore compatibility)

    suspend fun fetchUserTimeSlots(userId: String): TimeSlotResponse
    //suspend fun selectTimeSlot(timeslotId: Int,reservationDetails: ReservationDetails)

}
