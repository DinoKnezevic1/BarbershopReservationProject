package com.dinoknezevic.barbershopreservation.ui.finish

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinoknezevic.barbershopreservation.data.repository.BarbershopRepository
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.ui.finish.mapper.FinishScreenMapper
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FinishViewModel(
    private val barbershopRepository: BarbershopRepository,
    private val finishScreenMapper: FinishScreenMapper,
    @RequiresApi(Build.VERSION_CODES.O) val serviceId: Int,
    val pickedDate: Long,
): ViewModel() {

    val userId = FirebaseAuth.getInstance().currentUser

    val finishScreenViewState:StateFlow<FinishScreenViewState> =
        barbershopRepository.timeSlots(pickedDate)
            .map { finishScreenMapper.toFinishScreenViewState(it,serviceId,pickedDate) }.stateIn(
                viewModelScope,
                SharingStarted.Eagerly,
                FinishScreenViewState(listOf(), serviceId = serviceId, pickedDate = pickedDate)
            )

    fun createReservation(timeSlot: TimeSlot){
        viewModelScope.launch {
            barbershopRepository.bookTimeSlot(timeSlot)
        }
    }
}
