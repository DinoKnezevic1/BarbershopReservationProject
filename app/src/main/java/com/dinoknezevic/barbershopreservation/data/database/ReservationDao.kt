package com.dinoknezevic.barbershopreservation.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReservationDao {

    @Query("SELECT * FROM reservations")
    fun services(): Flow<List<DbService>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReservation(reservation: DbReservation)

    @Query("DELETE FROM reservations WHERE reservationId = :reservationId")
    fun deleteService(reservationId: Int)
}

