package com.dinoknezevic.barbershopreservation.data.network.model

import java.time.LocalDate
import java.time.LocalTime

data class ApiReservation(
    val id: Int,
    val userId: String,
    val name: String,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val reservationDate: LocalDate
)
