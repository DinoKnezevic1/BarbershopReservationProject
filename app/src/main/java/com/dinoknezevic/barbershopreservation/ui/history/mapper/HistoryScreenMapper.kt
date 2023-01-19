package com.dinoknezevic.barbershopreservation.ui.history.mapper

import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.ui.history.HistoryViewState

interface HistoryScreenMapper {
    fun toHistoryViewState(reservations: List<TimeSlot>): HistoryViewState
}