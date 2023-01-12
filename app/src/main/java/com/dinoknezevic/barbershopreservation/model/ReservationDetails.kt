package com.dinoknezevic.barbershopreservation.model

import java.time.LocalDate
import java.time.LocalTime

data class ReservationDetails(
    val id: Int,//would be nice to have serviceId so user can click it but he has the name so he can go check it on other screen?!
    val userId: String,
    val name: String,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val reservationDate: LocalDate
)
