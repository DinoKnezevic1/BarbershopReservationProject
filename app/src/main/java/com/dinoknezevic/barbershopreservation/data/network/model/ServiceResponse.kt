package com.dinoknezevic.barbershopreservation.data.network.model

import com.dinoknezevic.barbershopreservation.model.Service

data class ServiceResponse(
    val services: List<Service?>
)
