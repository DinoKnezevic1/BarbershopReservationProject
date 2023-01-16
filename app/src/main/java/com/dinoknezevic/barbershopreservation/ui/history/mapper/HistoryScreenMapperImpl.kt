package com.dinoknezevic.barbershopreservation.ui.history.mapper

import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import com.dinoknezevic.barbershopreservation.ui.history.HistoryViewState

class HistoryScreenMapperImpl : HistoryScreenMapper {
    override fun toHistoryViewState(reservations: List<ReservationDetails>): HistoryViewState {
        return HistoryViewState(
            reservations.map {
                ReservationDetails(
                    reservationId=it.reservationId,
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