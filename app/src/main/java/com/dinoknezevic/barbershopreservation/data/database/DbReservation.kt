package com.dinoknezevic.barbershopreservation.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime

@Entity(tableName = "reservations")
data class DbReservation(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "userId") val userId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name="startTime")val startTime: LocalTime,
    @ColumnInfo(name="endTime")val endTime: LocalTime,
    @ColumnInfo(name="reservationDate")val reservationDate: LocalDate
)
