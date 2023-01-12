package com.dinoknezevic.barbershopreservation.data.network.model

import com.dinoknezevic.barbershopreservation.model.ServiceType

data class ApiService(
    val id: Int,
    val type: ServiceType,
    val name: String,
    val description: String,
    val price: String
)