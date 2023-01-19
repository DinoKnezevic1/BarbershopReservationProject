package com.dinoknezevic.barbershopreservation.mock

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import com.dinoknezevic.barbershopreservation.model.Service
import com.dinoknezevic.barbershopreservation.model.ServiceType
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object BarberMock {
    @RequiresApi(Build.VERSION_CODES.O)
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    @RequiresApi(Build.VERSION_CODES.O)
    fun getTimeSlotsMocked():List<TimeSlot> = listOf(
        TimeSlot(
            timeSlotId = 1,
            userId ="-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.now().format(formatter),
            endTime = LocalTime.now().plusMinutes(45).format(formatter),
            name ="Modern Haircut(fade)",
        ),
        TimeSlot(
            timeSlotId = 2,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.now().plusMinutes(45).format(formatter),
            endTime = LocalTime.now().plusMinutes(45).format(formatter),
            name = "Classic Haircut",
        )
    )

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTimeSlotsForCalculations():List<TimeSlot> = listOf(
        TimeSlot(
            timeSlotId = -1,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(8,0).format(formatter),
            endTime = LocalTime.of(8,45).format(formatter),
            name ="",
        ),
        TimeSlot(
            timeSlotId = -2,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(8,45).format(formatter),
            endTime = LocalTime.of(9,30).format(formatter),
            name ="",
        ),
        TimeSlot(
            timeSlotId = -3,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(9,30).format(formatter),
            endTime = LocalTime.of(10,15).format(formatter),
            name ="",
        ),
        TimeSlot(
            timeSlotId = -4,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(10,15).format(formatter),
            endTime = LocalTime.of(11,0).format(formatter),
            name ="",
        ),
        TimeSlot(
            timeSlotId = -5,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(11,0).format(formatter),
            endTime = LocalTime.of(11,45).format(formatter),
            name ="",
        ),
        TimeSlot(
            timeSlotId = -6,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(11,45).format(formatter),
            endTime = LocalTime.of(12,30).format(formatter),
            name ="",
        ),
        TimeSlot(
            timeSlotId = -7,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(12,30).format(formatter),
            endTime = LocalTime.of(13,15).format(formatter),
            name ="",
        ),
        TimeSlot(
            timeSlotId = -8,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(13,15).format(formatter),
            endTime = LocalTime.of(14,0).format(formatter),
            name ="",
        ),TimeSlot(
            timeSlotId = -9,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(14,0).format(formatter),
            endTime = LocalTime.of(14,45).format(formatter),
            name ="",
        ),
        TimeSlot(
            timeSlotId = -10,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(15,45).format(formatter),
            endTime = LocalTime.of(15,30).format(formatter),
            name ="",
        ),
        TimeSlot(
            timeSlotId = -11,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(15,30).format(formatter),
            endTime = LocalTime.of(16,15).format(formatter),
            name ="",
        ),
        TimeSlot(
            timeSlotId = -12,
            userId = "-1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            startTime = LocalTime.of(16,15).format(formatter),
            endTime = LocalTime.of(17,0).format(formatter),
            name ="",
        ),
    )

    fun getServices(): List<Service> = listOf(
        Service(
            serviceId= 1,
            type = ServiceType.HAIRCUT,
            name = "Modern Haircut(fade)",
            description = "Most popular hairstyle with lots of variations.",
            price = "7.39$"
        ),
        Service(
            serviceId=2,
            type = ServiceType.HAIRCUT,
            name = "Classic Haircut",
            description = "For those who like it simple.",
            price = "5.39$"
        ),
        Service(
            serviceId=3,
            type = ServiceType.HAIRCUT,
            name = "Children's haircut",
            description = "We take extra care and try to make it fun!",
            price = "4.15$"
        ),
        Service(
            serviceId=4,
            type = ServiceType.HAIRCUT_AND_BEARD,
            name = "Modern Haircut(fade) + Beard",
            description = "Look sharp with modern hairstyle and a nice beard!",
            price = "12.00$"
        ),
        Service(
            serviceId=5,
            type = ServiceType.BEARD,
            name = "Beard trim",
            description = "A nice, clean and elegant beard.",
            price = "4.25$"
        ),
        Service(
            serviceId=6,
            type = ServiceType.BEARD,
            name = "Beard shave",
            description = "This will definitely make you look younger!",
            price = "6.50$"
        ),
        Service(
            serviceId = 7,
            type = ServiceType.HAIRCUT,
            name = "Kids haircut",
            description = "For the young, we take extra care",
            price = "3.5$"
        ),
    )

    @SuppressLint("NewApi")
    fun getHistory(): List<ReservationDetails> = listOf(
        ReservationDetails(
            reservationId=1,
            userId = "",
            name = "Modern Haircut(fade) + Beard",
            startTime = LocalTime.of(11, 0),
            endTime = LocalTime.of(11, 45),
            reservationDate = LocalDate.of(2023, 1, 10)
        ),
        ReservationDetails(
            reservationId=2,
            userId = "",
            name = "Modern haircut(fade)",
            startTime = LocalTime.of(12, 0),
            endTime = LocalTime.of(12, 30),
            reservationDate = LocalDate.of(2023, 1, 10)
        ),
        ReservationDetails(
            reservationId=3,
            userId = "",
            name = "Classic haircut + beard trim",
            startTime = LocalTime.of(12, 45),
            endTime = LocalTime.of(13, 30),
            reservationDate = LocalDate.of(2023, 1, 10)
        ),
        ReservationDetails(
            reservationId=4,
            userId = "",
            name = "Classic haircut",
            startTime = LocalTime.of(12, 45),
            endTime = LocalTime.of(13, 15),
            reservationDate = LocalDate.of(2023, 1, 10)
        ),
        ReservationDetails(
            reservationId=5,
            userId = "",
            name = "Classic haircut",
            startTime = LocalTime.of(11, 0),
            endTime = LocalTime.of(11, 45),
            reservationDate = LocalDate.of(2023, 1, 12)
        ),
        ReservationDetails(
            reservationId=6,
            userId = "0",
            name = "Modern haircut(fade)",
            startTime = LocalTime.of(12, 0),
            endTime = LocalTime.of(12, 30),
            reservationDate = LocalDate.of(2023, 1, 12)
        ),
        ReservationDetails(
            reservationId=7,
            userId = "",
            name = "Classic haircut + beard trim",
            startTime = LocalTime.of(12, 45),
            endTime = LocalTime.of(13, 30),
            reservationDate = LocalDate.of(2023, 1, 12)
        ),
        ReservationDetails(
            reservationId=8,
            userId = "",
            name = "Classic haircut",
            startTime = LocalTime.of(12, 45),
            endTime = LocalTime.of(13, 15),
            reservationDate = LocalDate.of(2023, 1, 12)
        ),


        )
}
