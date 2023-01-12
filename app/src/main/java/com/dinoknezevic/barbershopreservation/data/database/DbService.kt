package com.dinoknezevic.barbershopreservation.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dinoknezevic.barbershopreservation.model.ServiceType

@Entity(tableName = "services")
data class DbService(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "type") val type: ServiceType,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "price") val price: String
)
