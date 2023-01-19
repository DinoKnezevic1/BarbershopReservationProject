package com.dinoknezevic.barbershopreservation.ui.finish

import com.dinoknezevic.barbershopreservation.model.TimeSlot

data class FinishScreenViewState(
    val timeSlots: List<TimeSlot>,
    val pickedDate: Long,
    val serviceId: Int
)
