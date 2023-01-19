package com.dinoknezevic.barbershopreservation.ui.history.mapper

import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.ui.history.HistoryViewState

class HistoryScreenMapperImpl : HistoryScreenMapper {
    override fun toHistoryViewState(reservations: List<TimeSlot>): HistoryViewState {
        return HistoryViewState(
            reservations.map {
                TimeSlot(
                    timeSlotId=it.timeSlotId,
                    userId = it.userId,
                    name = it.name,
                    isAvailable = it.isAvailable,
                    startTime = it.startTime,
                    endTime = it.endTime,
                    date = it.date
                )
            }
        )
    }
}
