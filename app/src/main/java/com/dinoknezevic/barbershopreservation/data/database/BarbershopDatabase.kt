package com.dinoknezevic.barbershopreservation.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DbService::class, DbReservation::class], version = 1, exportSchema = false)
abstract class BarbershopDatabase : RoomDatabase() {
    abstract fun serviceDao(): ServiceDao
    abstract fun reservationDao(): ReservationDao
}
