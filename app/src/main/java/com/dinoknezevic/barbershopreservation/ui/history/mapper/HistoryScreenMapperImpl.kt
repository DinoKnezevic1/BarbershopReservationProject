package com.dinoknezevic.barbershopreservation.ui.history.mapper

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.setValue
import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import com.dinoknezevic.barbershopreservation.ui.history.HistoryReservationViewState
import com.dinoknezevic.barbershopreservation.ui.history.HistoryViewState

class HistoryScreenMapperImpl : HistoryScreenMapper {
    override fun toHistoryViewState(reservations: List<ReservationDetails>): HistoryViewState {
        return HistoryViewState(
            reservations.map {
                ReservationDetails(
                    id=it.id,
                    userId = it.userId,
                    name = it.name,
                    startTime = it.startTime,
                    endTime = it.endTime,
                    reservationDate = it.reservationDate
                )
            }
            //upcomingLabelActive = Boolean.
        )
    }
}