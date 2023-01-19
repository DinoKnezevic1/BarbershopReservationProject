package com.dinoknezevic.barbershopreservation.ui.finish.mapper

import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.ui.finish.FinishScreenViewState
import com.dinoknezevic.barbershopreservation.ui.pick.PickScreenViewState

interface FinishScreenMapper {
    fun toFinishScreenViewState(timeSlots: List<TimeSlot>, serviceId:Int, selectedDate:Long): FinishScreenViewState
}
