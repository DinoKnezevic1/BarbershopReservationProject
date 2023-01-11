package com.dinoknezevic.barbershopreservation.ui.history

import java.time.LocalDate
import java.time.LocalTime

data class HistoryViewState(
    val services: List<HistoryReservationViewState>,
    //val upcomingLabelActive: MutableState<Boolean>
)

data class HistoryReservationViewState(
    val name: String,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val reservationDate: LocalDate
)
