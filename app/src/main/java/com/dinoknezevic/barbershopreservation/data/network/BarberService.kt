package com.dinoknezevic.barbershopreservation.data.network

import com.dinoknezevic.barbershopreservation.data.network.model.ServiceResponse

interface BarberService {

    suspend fun fetchServices(): ServiceResponse

    suspend fun addService()

    suspend fun deleteService(serviceId: Int)

    suspend fun updateService(serviceId: Int)
}
