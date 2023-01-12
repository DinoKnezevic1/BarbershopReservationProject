package com.dinoknezevic.barbershopreservation.ui.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.ui.theme.DarkGrey
import com.dinoknezevic.barbershopreservation.ui.theme.LightGrey
import com.dinoknezevic.barbershopreservation.ui.theme.spacing
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

data class ReservationItemViewState(
    val name: String,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val reservationDate: LocalDate
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReservationItem(
    reservationItemViewState: ReservationItemViewState,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(horizontal = MaterialTheme.spacing.large, vertical = MaterialTheme.spacing.small)//vertical for preview only
            .background(
                color = LightGrey,
                shape = RoundedCornerShape(
                    MaterialTheme.spacing.medium
                )
            )
            .fillMaxWidth()
    ) {
        Text(
            text = reservationItemViewState.name,
            style = MaterialTheme.typography.h6,
            modifier = modifier
                .padding(horizontal = MaterialTheme.spacing.extraSmall)
        )
        Text(
            text = buildString {
                append(
                    reservationItemViewState.startTime.format(
                        DateTimeFormatter.ofLocalizedTime(
                            FormatStyle.SHORT
                        )
                    )
                )
                append(
                    " - ${
                        reservationItemViewState.endTime.format(
                            DateTimeFormatter.ofLocalizedTime(
                                FormatStyle.SHORT
                            )
                        )
                    }"
                )
            },
            fontSize = 14.sp,
            color = DarkGrey,
            modifier = modifier
                .padding(horizontal = MaterialTheme.spacing.extraSmall)
        )
        Text(
            text = reservationItemViewState.reservationDate.format(
                DateTimeFormatter.ofLocalizedDate(
                    FormatStyle.MEDIUM
                )
            ),
            fontSize = 18.sp,
            textAlign = TextAlign.End,
            color = Color.Black,
            modifier = modifier
                .padding(horizontal = MaterialTheme.spacing.extraSmall)
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ReservationItemPreview(

) {
    ReservationItem(
        reservationItemViewState = ReservationItemViewState(
            name = stringResource(id = R.string.modern_and_beard_trim),
            startTime = LocalTime.of(11, 0),
            endTime = LocalTime.of(11, 45),
            reservationDate = LocalDate.of(2023, 1, 10)
        )
    )
}
