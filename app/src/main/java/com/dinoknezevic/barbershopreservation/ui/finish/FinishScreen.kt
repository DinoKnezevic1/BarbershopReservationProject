package com.dinoknezevic.barbershopreservation.ui.finish

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.dinoknezevic.barbershopreservation.mock.BarberMock
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.navigation.HOME_ROUTE
import com.dinoknezevic.barbershopreservation.navigation.NavigationItem
import com.dinoknezevic.barbershopreservation.ui.component.TimeSlotCell
import com.dinoknezevic.barbershopreservation.ui.theme.spacing

const val NUMBER_OF_COLUMNS = 1

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FinishScreenRoute(
    viewModel: FinishViewModel,
    navController: NavController
) {
    val finishScreenViewState: FinishScreenViewState by viewModel.finishScreenViewState.collectAsState()
    FinishScreen(
        finishScreenViewState = finishScreenViewState,
        onCellClick = {
            viewModel.createReservation(it)

        },
        navController = navController
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FinishScreen(
    finishScreenViewState: FinishScreenViewState,
    modifier: Modifier = Modifier,
    onCellClick: (TimeSlot) -> Unit,
    navController: NavController
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(NUMBER_OF_COLUMNS),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(MaterialTheme.spacing.large),
    ) {
        items(
            items = finishScreenViewState.timeSlots,
            key = { timeSlot -> timeSlot.timeSlotId }
        ) { timeSlot ->
            val timeSlotCellViewState = TimeSlot(
                timeSlotId = timeSlot.timeSlotId,
                userId = timeSlot.userId,
                date = timeSlot.date,
                isAvailable = timeSlot.isAvailable,
                startTime = timeSlot.startTime,
                endTime = timeSlot.endTime,
                name = timeSlot.name,
            )
            TimeSlotCell(timeSlotCellViewState = timeSlotCellViewState, onCellClick = {
                //get date info from datepickerpopup
                val dateInfo = finishScreenViewState.pickedDate
                val services = BarberMock.getServices()
                val service = services.first {
                    it.serviceId == finishScreenViewState.serviceId
                }
                val pickedServiceName = service.name
                val pickedTimeSlotViewState = TimeSlot(
                    timeSlotId = timeSlot.timeSlotId,
                    userId = timeSlot.userId,
                    date = dateInfo,
                    isAvailable = false,//timeSlot.isAvailable,
                    startTime = timeSlot.startTime,
                    endTime = timeSlot.endTime,
                    name = pickedServiceName,
                )
                onCellClick(pickedTimeSlotViewState)
                navController.navigate(HOME_ROUTE)
            })
        }
    }
}
