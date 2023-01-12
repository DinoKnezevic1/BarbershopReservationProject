package com.dinoknezevic.barbershopreservation.data.network

import com.dinoknezevic.barbershopreservation.data.network.model.ReservationResponse

interface ReservationService {
    suspend fun fetchReservations(): ReservationResponse

    suspend fun addReservation()

    suspend fun deleteReservation(reservationId: Int)

    suspend fun updateReservation(reservationId: Int)
}