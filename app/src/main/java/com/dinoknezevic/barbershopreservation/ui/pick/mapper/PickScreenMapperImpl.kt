package com.dinoknezevic.barbershopreservation.ui.pick.mapper

import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.ui.pick.PickScreenViewState

class PickScreenMapperImpl:PickScreenMapper {
    override fun toPickScreenViewState(
        //timeSlots: List<TimeSlot>,
        serviceId:Int
    ): PickScreenViewState {
        return PickScreenViewState(
            /*timeSlots.map {
                TimeSlot(
                    timeSlotId = it.timeSlotId,
                    userId = it.userId!!,
                    date = it.date,
                    isAvailable = it.isAvailable,
                    startTime = it.startTime,
                    endTime = it.endTime,
                    name =it.name,
                )
            },*/
            serviceId=serviceId
        )
    }
}