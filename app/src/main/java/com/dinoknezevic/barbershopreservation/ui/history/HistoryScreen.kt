package com.dinoknezevic.barbershopreservation.ui.history

import android.os.Build
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
import com.dinoknezevic.barbershopreservation.mock.BarberMock
import com.dinoknezevic.barbershopreservation.ui.component.ReservationItem
import com.dinoknezevic.barbershopreservation.ui.component.ReservationItemViewState
import com.dinoknezevic.barbershopreservation.ui.history.mapper.HistoryScreenMapper
import com.dinoknezevic.barbershopreservation.ui.history.mapper.HistoryScreenMapperImpl
import com.dinoknezevic.barbershopreservation.ui.theme.BackgroundDarkViolet
import com.dinoknezevic.barbershopreservation.ui.theme.DarkGrey200
import com.dinoknezevic.barbershopreservation.ui.theme.spacing

const val NUMBER_OF_COLUMNS = 1
private val historyScreenMapper: HistoryScreenMapper = HistoryScreenMapperImpl()

val historyScreenViewState = historyScreenMapper.toHistoryViewState(BarberMock.getHistory())

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HistoryRoute(
    viewModel: HistoryViewModel
){
    var historyViewState by remember { mutableStateOf(historyScreenViewState) }

    HistoryScreen(historyViewState = historyViewState)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HistoryScreen(
    historyViewState: HistoryViewState,
    modifier: Modifier = Modifier.background(BackgroundDarkViolet),
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(NUMBER_OF_COLUMNS),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier,
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
        item {
            HistoryLabels()
        }
        items(historyViewState.services) { service ->
            val reservationViewState = ReservationItemViewState(
                service.name,
                service.startTime,
                service.endTime,
                service.reservationDate
            )
            ReservationItem(
                reservationItemViewState = reservationViewState,
            )
        }
    }
}

@Composable
fun HistoryLabels(
    modifier: Modifier = Modifier,
) {
    var labelState by remember { mutableStateOf(true) }
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .padding(horizontal = MaterialTheme.spacing.large)
                .fillMaxWidth()
        ) {
            Box(
                modifier = modifier
                    .clickable(onClick = { labelState = true })
                    .weight(1f)
            ) {
                if (labelState) {
                    Column(
                        modifier = modifier
                            .padding(bottom = MaterialTheme.spacing.extraSmall)
                            .width(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Text(
                            text = stringResource(id = R.string.upcoming),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(
                            modifier = Modifier
                                .size(6.dp)
                        )
                        Divider(
                            color = Color.White,
                            thickness = MaterialTheme.spacing.extraSmall,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                } else {
                    Text(
                        text = stringResource(id = R.string.upcoming),
                        color = DarkGrey200,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                }
            }
            Box(
                modifier = modifier
                    .clickable(onClick = { labelState = false })
                    .weight(1f)
            ) {
                if (!labelState) {
                    Column(
                        modifier = modifier
                            .padding(bottom = MaterialTheme.spacing.extraSmall)
                            .width(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Text(
                            text = stringResource(id = R.string.previous),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(
                            modifier = Modifier
                                .size(4.dp)
                        )
                        Divider(
                            color = Color.White,
                            thickness = MaterialTheme.spacing.extraSmall,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                } else {
                    Text(
                        text = stringResource(id = R.string.previous),
                        color = DarkGrey200,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                }
            }

        }
        Divider(
            color = Color.White,
            thickness = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.large)
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun HistoryScreenPreview(

) {
    HistoryScreen(historyScreenViewState)
}
