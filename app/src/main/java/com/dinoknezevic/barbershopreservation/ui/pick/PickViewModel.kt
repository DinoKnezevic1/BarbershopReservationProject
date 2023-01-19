package com.dinoknezevic.barbershopreservation.ui.pick

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinoknezevic.barbershopreservation.data.repository.BarbershopRepository
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.ui.pick.mapper.PickScreenMapper
import com.dinoknezevic.barbershopreservation.ui.reservation.ReservationsScreenViewState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Thread.State
import java.time.LocalDate
import java.time.ZoneId

class PickViewModel(
    private val barbershopRepository: BarbershopRepository,
    private val pickScreenMapper: PickScreenMapper,
    @RequiresApi(Build.VERSION_CODES.O) val serviceId: Int
) : ViewModel() {

    val pickScreenViewState: PickScreenViewState =
        pickScreenMapper.toPickScreenViewState(serviceId)

}
