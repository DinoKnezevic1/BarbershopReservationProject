package com.dinoknezevic.barbershopreservation.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ServiceDao {

    @Query("SELECT * FROM services")
    fun services(): Flow<List<DbService>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertService(service: DbService)

    @Query("DELETE FROM services WHERE id = :serviceId")
    fun deleteService(serviceId: Int)
}
