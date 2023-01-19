package com.dinoknezevic.barbershopreservation.ui.history

import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import java.time.LocalDate
import java.time.LocalTime

data class HistoryViewState(
    var services: List<TimeSlot>,
    //val upcomingLabelActive: MutableState<Boolean>
)

data class HistoryReservationViewState(
    val id: Int,
    val name: String,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val reservationDate: LocalDate
)
