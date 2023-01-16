package com.dinoknezevic.barbershopreservation.data.database

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import com.google.gson.Gson
import java.time.LocalDate
import java.time.LocalTime

@Database(entities = [DbService::class, DbTimeSlot::class], version = 1, exportSchema = false)
@TypeConverters(ReservationDetailsTypeConverter::class,LocalDateConverter::class,LocalTimeConverter::class)
abstract class BarbershopDatabase : RoomDatabase() {
    abstract fun serviceDao(): ServiceDao
    abstract fun timeSlotDao(): TimeSlotDao
    //abstract fun reservationDao(): ReservationDao
}

class ReservationDetailsTypeConverter {

    @TypeConverter
    fun fromReservationDetails(reservationDetails: ReservationDetails): String {
        // Convert the ReservationDetails object to a JSON string
        return Gson().toJson(reservationDetails)
    }

    @TypeConverter
    fun toReservationDetails(json: String): ReservationDetails {
        // Convert the JSON string to a ReservationDetails object
        return Gson().fromJson(json, ReservationDetails::class.java)
    }
}
class LocalDateConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): Long? {
        return date?.toEpochDay()
    }
}

class LocalTimeConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalTime? {
        return value?.let { LocalTime.ofNanoOfDay(it) }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun dateToTimestamp(date: LocalTime?): Long? {
        return date?.toNanoOfDay()
    }
}
