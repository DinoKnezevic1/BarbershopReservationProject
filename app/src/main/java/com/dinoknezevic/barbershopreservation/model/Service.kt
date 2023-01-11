package com.dinoknezevic.barbershopreservation.model

data class Service(
    val id: Int,
    val type: ServiceType,
    val name: String,
    val description: String,
    val price: String
)