package com.dinoknezevic.barbershopreservation.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ServiceDao {

    @Query("SELECT * FROM services")
    fun services(): Flow<List<DbService>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertService(service: DbService)

    @Query("DELETE FROM services WHERE serviceId = :serviceId")
    suspend fun deleteService(serviceId: Int)

    @Update(entity = DbService::class)
    suspend fun updateService(service: DbService)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertServices(services: List<DbService>)

}
