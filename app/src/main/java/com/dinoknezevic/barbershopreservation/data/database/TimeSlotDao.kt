package com.dinoknezevic.barbershopreservation.data.database

import androidx.room.*
import com.dinoknezevic.barbershopreservation.model.ReservationDetails
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface TimeSlotDao {

    @Query("SELECT * FROM timeSlots WHERE date = :date")
    fun timeSlots(date: Long): Flow<List<DbTimeSlot>>//list of timeslots for that day

    //@Query("SELECT * FROM timeSlots WHERE timeSlotId = :timeslotId")
    //fun selectTimeSlot(timeslotId: Int,reservationDetails: ReservationDetails)//contains userId

    //@Update(entity = DbTimeSlot::class)
    //suspend fun updateTimeSlotAvailability(timeSlotId: Int, isAvailable: Boolean)

    //@Query("SELECT * FROM timeSlots WHERE timeSlotId = :timeslotId")
    //fun cancelTimeSlot(timeslotId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTimeSlot(timeSlot: DbTimeSlot)//maybe java.utill class(firestore compatibility)

    @Query("SELECT * FROM timeSlots WHERE userId = :userId")
    fun userTimeSlots(userId:Int):Flow<List<DbTimeSlot>>
}
