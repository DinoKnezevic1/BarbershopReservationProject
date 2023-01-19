package com.dinoknezevic.barbershopreservation.ui.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dinoknezevic.barbershopreservation.model.TimeSlot
import com.dinoknezevic.barbershopreservation.ui.theme.LightGrey
import com.dinoknezevic.barbershopreservation.ui.theme.spacing
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeSlotCell(
    timeSlotCellViewState: TimeSlot,
    modifier: Modifier = Modifier,
    onCellClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(
                horizontal = MaterialTheme.spacing.large,
                vertical = MaterialTheme.spacing.medium
            )
            .background(
                color = LightGrey,
                shape = RoundedCornerShape(
                    MaterialTheme.spacing.medium
                )
            )
            .fillMaxWidth()
            .clickable {
                onCellClick()
            }
    ) {
        Text(
            text = buildString {
                append(
                    timeSlotCellViewState.startTime.format(
                        DateTimeFormatter.ofLocalizedTime(
                            FormatStyle.SHORT
                        )
                    )
                )
                append(
                    " - ${
                        timeSlotCellViewState.endTime.format(
                            DateTimeFormatter.ofLocalizedTime(
                                FormatStyle.SHORT
                            )
                        )
                    }"
                )
            },
            fontSize = 24.sp,
            color = Color.Black,
            modifier = modifier
                .padding(horizontal = MaterialTheme.spacing.extraSmall, vertical = MaterialTheme.spacing.small)
        )
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun TimeSlotCellPreview(

) {
    TimeSlotCell(
        timeSlotCellViewState = TimeSlot(
            startTime = LocalTime.now().toString(),
            endTime = LocalTime.now().plusMinutes(45).toString(),
            timeSlotId = 1,
            userId = "1",
            date = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
            isAvailable = true,
            name = "Classic Haircut",
        ),
        onCellClick = { }
    )
}
