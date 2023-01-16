package com.dinoknezevic.barbershopreservation.model

data class TimeSlot(
    val timeSlotId: Int,
    val userId: Int,
    val date: Long,//java.util because firebase? potentially //as string because i only have to compare if they are the same
    val isAvailable: Boolean?,
    val startTime: String,
    val endTime: String,
    val name:String
)
