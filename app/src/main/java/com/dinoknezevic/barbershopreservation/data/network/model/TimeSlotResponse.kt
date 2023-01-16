package com.dinoknezevic.barbershopreservation.data.network.model

import com.dinoknezevic.barbershopreservation.model.TimeSlot

data class TimeSlotResponse(
    val timeSlots: List<TimeSlot?>
)