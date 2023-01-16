package com.dinoknezevic.barbershopreservation.model

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class Service(
    val serviceId: Int,
    val type: ServiceType,
    val name: String,
    val description: String,
    val price: String
)