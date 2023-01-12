package com.dinoknezevic.barbershopreservation.ui.reservation.di

import com.dinoknezevic.barbershopreservation.ui.reservation.ReservationViewModel
import com.dinoknezevic.barbershopreservation.ui.reservation.mapper.ReservationsScreenMapper
import com.dinoknezevic.barbershopreservation.ui.reservation.mapper.ReservationsScreenMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val reservationModule = module {
    viewModel {
        ReservationViewModel(
            barbershopRepository = get(),
            reservationMapper = get()
        )
    }

    single<ReservationsScreenMapper> { ReservationsScreenMapperImpl() }
}
