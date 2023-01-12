package com.dinoknezevic.barbershopreservation.data.di

import com.dinoknezevic.barbershopreservation.data.network.BarberService
import com.dinoknezevic.barbershopreservation.data.network.BarberServiceImpl
import com.dinoknezevic.barbershopreservation.data.network.ReservationService
import com.dinoknezevic.barbershopreservation.data.network.ReservationServiceImpl
import org.koin.dsl.module

val networkModule = module {

    single<BarberService> { BarberServiceImpl() }

    single<ReservationService> { ReservationServiceImpl() }
}
