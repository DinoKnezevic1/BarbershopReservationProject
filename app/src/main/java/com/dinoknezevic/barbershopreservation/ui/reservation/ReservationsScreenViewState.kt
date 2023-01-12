package com.dinoknezevic.barbershopreservation.ui.reservation

import com.dinoknezevic.barbershopreservation.model.Service
import java.time.LocalDate
import java.time.LocalTime

data class ReservationsScreenViewState(
    val servicesList: List<Service>
)

data class DateTimePickerViewState(
    val selectedDate: LocalDate,
    val selectedTime: LocalTime,
    val popupShown: Boolean
)