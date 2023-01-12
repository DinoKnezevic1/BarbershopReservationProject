package com.dinoknezevic.barbershopreservation.ui.history.di

import com.dinoknezevic.barbershopreservation.ui.history.HistoryViewModel
import com.dinoknezevic.barbershopreservation.ui.history.mapper.HistoryScreenMapper
import com.dinoknezevic.barbershopreservation.ui.history.mapper.HistoryScreenMapperImpl
import com.dinoknezevic.barbershopreservation.ui.reservation.ReservationViewModel
import com.dinoknezevic.barbershopreservation.ui.reservation.mapper.ReservationsScreenMapper
import com.dinoknezevic.barbershopreservation.ui.reservation.mapper.ReservationsScreenMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val historyModule = module {
    viewModel {
        HistoryViewModel(
            barbershopRepository = get(),
            historyMapper = get()
        )
    }

    single<HistoryScreenMapper> { HistoryScreenMapperImpl() }
}
