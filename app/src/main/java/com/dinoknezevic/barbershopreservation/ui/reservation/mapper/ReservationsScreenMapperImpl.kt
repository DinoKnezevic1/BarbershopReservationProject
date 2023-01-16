package com.dinoknezevic.barbershopreservation.ui.reservation.mapper

import com.dinoknezevic.barbershopreservation.model.Service
import com.dinoknezevic.barbershopreservation.ui.reservation.ReservationsScreenViewState

class ReservationsScreenMapperImpl : ReservationsScreenMapper {
    override fun toReservationsScreenViewState(services: List<Service>): ReservationsScreenViewState {
        return ReservationsScreenViewState(
            services.map {
                Service(
                    serviceId = it.serviceId,
                    type = it.type,
                    name = it.name,
                    description = it.description,
                    price = it.price
                )
            }
        )
    }
}