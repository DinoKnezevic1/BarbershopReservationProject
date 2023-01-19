package com.dinoknezevic.barbershopreservation.data.network

import com.dinoknezevic.barbershopreservation.data.network.model.ServiceResponse
import com.dinoknezevic.barbershopreservation.model.Service
import com.dinoknezevic.barbershopreservation.model.ServiceType
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class BarberServiceImpl(
    private val bgDispatcher: CoroutineDispatcher
) : BarberService {
    private val databaseFirebase = FirebaseFirestore.getInstance()
    private val collectionPath = "services"
    private val servicesRef = databaseFirebase.collection(collectionPath)

    override suspend fun fetchServices(): ServiceResponse {
        val servicesSnapshot = servicesRef.get().await()
        val servicesList = mutableListOf<Service>()
        servicesSnapshot.forEach { document ->
            val serviceId = document.get("serviceId") as Long
            val type = document.get("type") as String
            val name = document.get("name") as String
            val description = document.get("description") as String
            val price = document.get("price") as String
            val service =
                Service(
                    serviceId.toInt(),
                    ServiceType.valueOf(type),
                    name,
                    description,
                    price
                )
            servicesList.add(service)
        }
        return ServiceResponse(servicesList)
    }

    override suspend fun addService(service: Service) {
        withContext(bgDispatcher) {
            servicesRef.document(service.serviceId.toString()).set(service)
        }
    }

    override suspend fun deleteService(serviceId: Int) {
        servicesRef.document(serviceId.toString()).delete()
    }

    override suspend fun updateService(serviceId: Int, updates: Map<String, Any>) {
        servicesRef.document(serviceId.toString()).update(updates)
    }

}
