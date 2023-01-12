package com.dinoknezevic.barbershopreservation

import android.app.Application
import android.util.Log
import com.dinoknezevic.barbershopreservation.data.di.dataModule
import com.dinoknezevic.barbershopreservation.data.di.databaseModule
import com.dinoknezevic.barbershopreservation.data.di.networkModule
import com.dinoknezevic.barbershopreservation.ui.history.di.historyModule
import com.dinoknezevic.barbershopreservation.ui.reservation.di.reservationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BarbershopReservation : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BarbershopReservation)
            modules(
                databaseModule,
                networkModule,
                dataModule,
                historyModule,
                reservationModule,
            )
        }

        Log.d("Barbershop Reservation application by Dino Knezevic", "App started")
    }
}
