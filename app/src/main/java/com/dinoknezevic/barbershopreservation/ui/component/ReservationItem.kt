package com.dinoknezevic.barbershopreservation.ui.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.ui.theme.DarkGrey
import com.dinoknezevic.barbershopreservation.ui.theme.LightGrey
import com.dinoknezevic.barbershopreservation.ui.theme.SoftRed
import com.dinoknezevic.barbershopreservation.ui.theme.spacing
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

data class ReservationItemViewState(
    val id:Int,
    val name: String,
    val startTime: String,
    val endTime: String,
    val reservationDate: LocalDate
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReservationItem(
    reservationItemViewState: ReservationItemViewState,
    modifier: Modifier = Modifier,
    onClick:()->Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(
                horizontal = MaterialTheme.spacing.large,
                vertical = MaterialTheme.spacing.small
            )//vertical for preview only
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
            textAlign=TextAlign.Center,
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
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_minus_thick), contentDescription = null,
            modifier = modifier
                .padding(vertical = MaterialTheme.spacing.small)
                .clickable {  onClick()},
            colorFilter = ColorFilter.tint(color = SoftRed)
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ReservationItemPreview(

) {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    ReservationItem(
        reservationItemViewState = ReservationItemViewState(
            id=1,
            name = stringResource(id = R.string.modern_and_beard_trim),
            startTime = LocalTime.of(11, 0).format(formatter),
            endTime = LocalTime.of(11, 45).format(formatter),
            reservationDate = LocalDate.of(2023, 1, 10)
        ),
        onClick = { }
    )
}
