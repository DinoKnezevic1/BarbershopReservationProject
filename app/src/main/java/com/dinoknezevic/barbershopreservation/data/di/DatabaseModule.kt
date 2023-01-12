package com.dinoknezevic.barbershopreservation.data.di

import androidx.room.Room
import com.dinoknezevic.barbershopreservation.data.database.BarbershopDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

private const val APP_DATABASE_NAME = "app_database.db"

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            BarbershopDatabase::class.java,
            APP_DATABASE_NAME,
        ).build()
    }

    fun provideServiceDao(database: BarbershopDatabase) = database.serviceDao()
    single { provideServiceDao(get()) }

    fun provideReservationDao(database: BarbershopDatabase) = database.reservationDao()
    single { provideReservationDao(get()) }
}
