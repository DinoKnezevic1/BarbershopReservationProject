package com.dinoknezevic.barbershopreservation.data.repository

import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import com.dinoknezevic.barbershopreservation.model.Service
import kotlinx.coroutines.flow.Flow

interface BarbershopRepository {
    fun services(): Flow<List<Service>> // retrieve list of services for reservations screen
    fun reservations(): Flow<List<ReservationDetails>> // retrieve list of services for history screen

    suspend fun makeReservation(reservationDetails: ReservationDetails)
    suspend fun removeReservation(reservationId: String)
}