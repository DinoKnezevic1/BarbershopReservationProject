package com.dinoknezevic.barbershopreservation.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timeSlots")
data class DbTimeSlot(
    @PrimaryKey val timeSlotId: Int,
    @ColumnInfo(name = "userId") val userId: String?,
    @ColumnInfo(name = "date") val date: Long,
    @ColumnInfo(name = "is_available") val isAvailable: Boolean,
    @ColumnInfo(name = "start_time") val startTime: String,
    @ColumnInfo(name = "end_time") val endTime: String,
    @ColumnInfo(name = "serviceName") val name:String
)
