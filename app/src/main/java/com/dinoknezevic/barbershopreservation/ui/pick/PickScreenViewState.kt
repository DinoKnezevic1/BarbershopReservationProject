package com.dinoknezevic.barbershopreservation.ui.pick

import com.dinoknezevic.barbershopreservation.model.TimeSlot

data class PickScreenViewState(
    val timeSlots:List<TimeSlot>,
    val serviceId:Int
)