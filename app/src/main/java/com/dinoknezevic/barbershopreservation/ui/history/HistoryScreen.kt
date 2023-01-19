package com.dinoknezevic.barbershopreservation.ui.history

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.navigation.NavigationItem
import com.dinoknezevic.barbershopreservation.ui.component.ReservationItem
import com.dinoknezevic.barbershopreservation.ui.component.ReservationItemViewState
import com.dinoknezevic.barbershopreservation.ui.theme.BackgroundDarkViolet
import com.dinoknezevic.barbershopreservation.ui.theme.DarkGrey200
import com.dinoknezevic.barbershopreservation.ui.theme.spacing
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

const val NUMBER_OF_COLUMNS = 1

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HistoryRoute(
    viewModel: HistoryViewModel
) {
    val historyViewState: HistoryViewState by viewModel.historyViewState.collectAsState()
    //var historyViewState by remember { mutableStateOf(historyScreenViewState) }
    HistoryScreen(
        historyViewState = historyViewState,
        onClick = {
            viewModel.cancelReservation(it)
            Log.d("timeSlotId", it.toString() + "timeSlotId/n")
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HistoryScreen(
    historyViewState: HistoryViewState,
    modifier: Modifier = Modifier.background(BackgroundDarkViolet),
    onClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(NUMBER_OF_COLUMNS),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxHeight(),//works?!
    ) {
        item {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_haircut_beard),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .padding(
                        horizontal = MaterialTheme.spacing.large,
                        vertical = MaterialTheme.spacing.medium
                    )
                    .size(180.dp)
            )
        }
        items(
            historyViewState.services,
            key = { timeSlot -> timeSlot.timeSlotId }
        ) { service ->
            val instant = Instant.ofEpochMilli(service.date)
            val zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())
            val localDate = zonedDateTime.toLocalDate()
            val reservationViewState = ReservationItemViewState(
                service.timeSlotId,
                service.name,
                service.startTime,
                service.endTime,
                localDate
            )
            ReservationItem(
                reservationItemViewState = reservationViewState,
                onClick = {
                    onClick(reservationViewState.id)
                }
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun HistoryScreenPreview(

) {
    //HistoryScreen(historyScreenViewState)
}
