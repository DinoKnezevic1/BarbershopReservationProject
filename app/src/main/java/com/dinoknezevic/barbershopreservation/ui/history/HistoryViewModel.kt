package com.dinoknezevic.barbershopreservation.ui.history

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinoknezevic.barbershopreservation.data.repository.BarbershopRepository
import com.dinoknezevic.barbershopreservation.ui.history.mapper.HistoryScreenMapper
import com.dinoknezevic.barbershopreservation.ui.reservation.mapper.ReservationsScreenMapper
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class HistoryViewModel(
    private val barbershopRepository: BarbershopRepository,
    private val historyMapper: HistoryScreenMapper,
) : ViewModel() {

    val userId = -1

    val historyViewState: StateFlow<HistoryViewState> =
        barbershopRepository.timeSlotsHistory(userId.toString())
            .map {
                historyMapper.toHistoryViewState(it)
            }.stateIn(
                viewModelScope,
                SharingStarted.Eagerly,
                HistoryViewState(listOf())
            )
    fun cancelReservation(timeSlotId:Int){
        viewModelScope.launch {
            barbershopRepository.deleteTimeSlot(timeSlotId)
            historyViewState.value.services.dropWhile {
                it.timeSlotId==timeSlotId
            }
        }
    }

}
