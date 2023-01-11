package com.dinoknezevic.barbershopreservation.model

import java.time.LocalDate
import java.time.LocalTime

data class ReservationDetails(
    val name: String,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val reservationDate: LocalDate
)