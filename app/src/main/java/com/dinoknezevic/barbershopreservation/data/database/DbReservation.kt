package com.dinoknezevic.barbershopreservation.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime

@Entity(tableName = "reservations")
data class DbReservation(
    @PrimaryKey val reservationId: Int,
    @ColumnInfo(name = "userId") val userId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date") val date: LocalDate,
    @ColumnInfo(name="startTime")val startTime: LocalTime,
    @ColumnInfo(name="endTime")val endTime: LocalTime,
    //@ColumnInfo(name = "serviceId")val serviceId: Int, if I have time
)
