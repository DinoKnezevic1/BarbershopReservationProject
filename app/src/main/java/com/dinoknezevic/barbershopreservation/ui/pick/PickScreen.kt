package com.dinoknezevic.barbershopreservation.ui.pick

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dinoknezevic.barbershopreservation.mock.BarberMock
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.ui.theme.spacing
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import com.dinoknezevic.barbershopreservation.ui.component.TimeSlotCell
import java.time.ZoneId

const val NUMBER_OF_COLUMNS = 1

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PickScreenRoute(
    viewModel: PickViewModel,
) {
    //val reservationsScreenViewState: ReservationsScreenViewState by viewModel.reservationsScreenViewState.collectAsState()
    val pickViewState: PickScreenViewState by viewModel.pickScreenViewState.collectAsState()
    //val pickScreenViewState
    val timeslotsForCalculations = BarberMock.getTimeSlotsForCalculations()
    PickScreen(
        //pickScreenViewState = PickScreenViewState(listOf(), viewModel.serviceId),
        pickScreenViewState = pickViewState,
        onCellClick = {
            viewModel.createReservation(it)
        },
        onDateSelected = {
            viewModel.fetchTimeSlotsForCurrentDate(it)
            viewModel.selectedDate=it
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PickScreen(
    pickScreenViewState: PickScreenViewState,
    onCellClick: (TimeSlot) -> Unit,
    onDateSelected: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    //Text(text = pickScreenViewState.testText)

    val dateDialogState = rememberMaterialDialogState()
    var pickedDate = LocalDate.now()
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MM dd yyyy")
                .format(pickedDate)
        }
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(NUMBER_OF_COLUMNS),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(MaterialTheme.spacing.large),
        state = rememberLazyGridState()
    ) {
        item {
            //DatePickerPopup(pickerViewState = PickerViewState(pickScreenViewState.pickedDate))
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                //not needed only need dateDialogState.show inside onClick for item
                Button(onClick = {
                    dateDialogState.show()
                }) {
                    Text(text = "Pick a date")
                }
                Text(text = formattedDate)
            }
            //dateDialogState.show()
            MaterialDialog(
                dialogState = dateDialogState,
                buttons = {
                    positiveButton(text = "Ok",
                        onClick = {
                            onDateSelected(
                                pickedDate.atStartOfDay(
                                    ZoneId.systemDefault()
                                ).toInstant().toEpochMilli()
                            )
                        }
                    )
                    negativeButton(text = "Cancel")
                }
            ) {
                datepicker(
                    initialDate = LocalDate.now(),
                    title = "Pick a date",
                ) {
                    pickedDate = it
                }
            }
        }
        items(
            pickScreenViewState.timeSlots
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
                val dateInfo = pickedDate.atStartOfDay(
                    ZoneId.systemDefault()
                ).toInstant().toEpochMilli()
                val services = BarberMock.getServices()
                val service = services.first {
                    it.serviceId == pickScreenViewState.serviceId
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
                onCellClick(pickedTimeSlotViewState)//predaje se viewState
            })
        }
    }

}
