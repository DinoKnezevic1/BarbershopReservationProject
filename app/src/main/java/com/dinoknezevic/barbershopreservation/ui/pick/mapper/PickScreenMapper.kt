package com.dinoknezevic.barbershopreservation.ui.pick.mapper

import com.dinoknezevic.barbershopreservation.model.Service
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.ui.pick.PickScreenViewState
import com.dinoknezevic.barbershopreservation.ui.reservation.ReservationsScreenViewState

interface PickScreenMapper {
    fun toPickScreenViewState(
        //timeSlots: List<TimeSlot>,
        serviceId:Int
    ): PickScreenViewState
}