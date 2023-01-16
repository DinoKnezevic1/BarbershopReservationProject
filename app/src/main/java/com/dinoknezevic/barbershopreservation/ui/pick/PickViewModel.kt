package com.dinoknezevic.barbershopreservation.ui.pick

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinoknezevic.barbershopreservation.data.repository.BarbershopRepository
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.ui.pick.mapper.PickScreenMapper
import com.dinoknezevic.barbershopreservation.ui.reservation.ReservationsScreenViewState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalDate

class PickViewModel(
    private val barbershopRepository: BarbershopRepository,
    private val pickScreenMapper: PickScreenMapper,
    serviceId: Int
):ViewModel() {
    @RequiresApi(Build.VERSION_CODES.O)
    val serviceId=serviceId
    var selectedDate:Long = 1

    val pickScreenViewState: StateFlow<PickScreenViewState> =
        barbershopRepository.timeSlots()
            .map { pickScreenMapper.toPickScreenViewState(it, serviceId) }.stateIn(
                viewModelScope,
                SharingStarted.Eagerly,
                PickScreenViewState(listOf(),serviceId)
            ) as StateFlow<PickScreenViewState>

    fun createReservation(timeSlot: TimeSlot){
        viewModelScope.launch {
            barbershopRepository.bookTimeSlot(timeSlot)
        }
    }

    fun fetchTimeSlotsForCurrentDate(currentDate:Long){
        viewModelScope.launch {
            barbershopRepository.fetchTimeSlotsForCurrentDay(currentDate)
        }
    }

    fun setDate(currentDate: Long){
        barbershopRepository.setDate(currentDate)
    }

}
