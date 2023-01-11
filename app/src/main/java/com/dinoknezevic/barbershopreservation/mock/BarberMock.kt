package com.dinoknezevic.barbershopreservation.mock

import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import com.dinoknezevic.barbershopreservation.model.Service
import com.dinoknezevic.barbershopreservation.model.ServiceType
import com.dinoknezevic.barbershopreservation.ui.component.ServiceItemViewState
import java.time.LocalDate
import java.time.LocalTime

object BarberMock {
    fun getServices(): List<Service> = listOf(
        Service(
            id= 1,
            type = ServiceType.HAIRCUT,
            name = "Modern Haircut(fade)",
            description = "Most popular hairstyle with lots of variations.",
            price = "7.39$"
        ),
        Service(
            id=2,
            type = ServiceType.HAIRCUT,
            name = "Classic Haircut",
            description = "For those who like it simple.",
            price = "5.39$"
        ),
        Service(
            id=3,
            type = ServiceType.HAIRCUT,
            name = "Children's haircut",
            description = "We take extra care and try to make it fun!",
            price = "4.15$"
        ),
        Service(
            id=4,
            type = ServiceType.HAIRCUT_AND_BEARD,
            name = "Modern Haircut(fade) + Beard",
            description = "Look sharp with modern hairstyle and a nice beard!",
            price = "12.00$"
        ),
        Service(
            id=5,
            type = ServiceType.BEARD,
            name = "Beard trim",
            description = "A nice, clean and elegant beard.",
            price = "4.25$"
        ),
        Service(
            id=6,
            type = ServiceType.BEARD,
            name = "Beard shave",
            description = "This will definitely make you look younger!",
            price = "6.50$"
        ),
    )

    fun getHistory(): List<ReservationDetails> = listOf(
        ReservationDetails(
            name = "Modern Haircut(fade) + Beard",
            startTime = LocalTime.of(11, 0),
            endTime = LocalTime.of(11, 45),
            reservationDate = LocalDate.of(2023, 1, 10)
        ),
        ReservationDetails(
            name = "Modern haircut(fade)",
            startTime = LocalTime.of(12, 0),
            endTime = LocalTime.of(12, 30),
            reservationDate = LocalDate.of(2023, 1, 10)
        ),
        ReservationDetails(
            name = "Classic haircut + beard trim",
            startTime = LocalTime.of(12, 45),
            endTime = LocalTime.of(13, 30),
            reservationDate = LocalDate.of(2023, 1, 10)
        ),
        ReservationDetails(
            name = "Classic haircut",
            startTime = LocalTime.of(12, 45),
            endTime = LocalTime.of(13, 15),
            reservationDate = LocalDate.of(2023, 1, 10)
        ),
        ReservationDetails(
            name = "Classic haircut",
            startTime = LocalTime.of(11, 0),
            endTime = LocalTime.of(11, 45),
            reservationDate = LocalDate.of(2023, 1, 12)
        ),
        ReservationDetails(
            name = "Modern haircut(fade)",
            startTime = LocalTime.of(12, 0),
            endTime = LocalTime.of(12, 30),
            reservationDate = LocalDate.of(2023, 1, 12)
        ),
        ReservationDetails(
            name = "Classic haircut + beard trim",
            startTime = LocalTime.of(12, 45),
            endTime = LocalTime.of(13, 30),
            reservationDate = LocalDate.of(2023, 1, 12)
        ),
        ReservationDetails(
            name = "Classic haircut",
            startTime = LocalTime.of(12, 45),
            endTime = LocalTime.of(13, 15),
            reservationDate = LocalDate.of(2023, 1, 12)
        ),


        )
}


/*
    fun getCrewman(): Crewman = Crewman(
        id = 1,
        name = "Jon Favreau",
        job = "Director"
    )*/

