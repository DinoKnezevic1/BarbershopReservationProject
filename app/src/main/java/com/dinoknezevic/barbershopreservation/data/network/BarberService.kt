package com.dinoknezevic.barbershopreservation.data.network

import com.dinoknezevic.barbershopreservation.data.network.model.ServiceResponse
import com.dinoknezevic.barbershopreservation.model.Service

interface BarberService {

    suspend fun fetchServices(): ServiceResponse

    suspend fun addService(service: Service)

    suspend fun deleteService(serviceId: Int)

    suspend fun updateService(serviceId: Int,updates: Map<String, Any>)
}
