package com.dinoknezevic.barbershopreservation.ui.history

import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import java.time.LocalDate
import java.time.LocalTime

data class HistoryViewState(
    val services: List<ReservationDetails>,
    //val upcomingLabelActive: MutableState<Boolean>
)

data class HistoryReservationViewState(
    val id: Int,
    val name: String,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val reservationDate: LocalDate
)
