package com.dinoknezevic.barbershopreservation.data.di

import com.dinoknezevic.barbershopreservation.data.network.BarberService
import com.dinoknezevic.barbershopreservation.data.network.BarberServiceImpl
import com.dinoknezevic.barbershopreservation.data.network.TimeSlotService
import com.dinoknezevic.barbershopreservation.data.network.TimeSlotServiceImpl
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import kotlinx.coroutines.CoroutineDispatcher

val networkModule = module {

    single<BarberService> {
        BarberServiceImpl(
            bgDispatcher = Dispatchers.IO
        )
    }

    single<TimeSlotService> {
        TimeSlotServiceImpl(
            bgDispatcher = Dispatchers.IO
        )
    }

    single { Firebase.firestore }
}
