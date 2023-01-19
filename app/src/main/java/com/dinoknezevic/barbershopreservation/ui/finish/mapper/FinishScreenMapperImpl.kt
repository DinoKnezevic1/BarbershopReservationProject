package com.dinoknezevic.barbershopreservation.ui.finish.mapper

import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.ui.finish.FinishScreenViewState

class FinishScreenMapperImpl:FinishScreenMapper {
    override fun toFinishScreenViewState(
        timeSlots: List<TimeSlot>,
        serviceId: Int,
        selectedDate: Long
    ): FinishScreenViewState {
        return FinishScreenViewState(
            timeSlots.map {
                TimeSlot(
                    timeSlotId = it.timeSlotId,
                    userId = it.userId!!,
                    date = it.date,
                    isAvailable = it.isAvailable,
                    startTime = it.startTime,
                    endTime = it.endTime,
                    name =it.name,
                )
            },serviceId=serviceId,
            pickedDate = selectedDate
        )
    }
}