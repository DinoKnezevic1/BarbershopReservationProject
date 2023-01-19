package com.dinoknezevic.barbershopreservation.model

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class TimeSlot(
    var timeSlotId: Int,
    val userId: String,
    val date: Long,//java.util because firebase? potentially //as string because i only have to compare if they are the same
    @JvmField
    val isAvailable: Boolean,
    val startTime: String,
    val endTime: String,
    val name:String
)
