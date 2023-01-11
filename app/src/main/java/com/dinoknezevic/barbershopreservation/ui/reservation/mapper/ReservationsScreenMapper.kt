package com.dinoknezevic.barbershopreservation.ui.reservation.mapper

import com.dinoknezevic.barbershopreservation.model.Service
import com.dinoknezevic.barbershopreservation.ui.reservation.ReservationsScreenViewState

interface ReservationsScreenMapper {
    fun toReservationsScreenViewState(services: List<Service>):ReservationsScreenViewState
}