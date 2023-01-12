package com.dinoknezevic.barbershopreservation.data.di

import com.dinoknezevic.barbershopreservation.data.repository.BarbershopRepository
import com.dinoknezevic.barbershopreservation.data.repository.BarbershopRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {

    single<BarbershopRepository> {
        BarbershopRepositoryImpl(
            barberService = get(),
            serviceDao = get(),
            reservationService=get(),
            reservationDao=get(),
            bgDispatcher = Dispatchers.IO
        )
    }
}
