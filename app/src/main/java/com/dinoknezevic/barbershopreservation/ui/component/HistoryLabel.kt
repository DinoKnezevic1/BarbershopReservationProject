package com.dinoknezevic.barbershopreservation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dinoknezevic.barbershopreservation.ui.theme.DarkGrey200
import com.dinoknezevic.barbershopreservation.ui.theme.spacing

data class HistoryLabelViewState(
    val isSelected: Boolean,
    val labelText: String
)

@Composable
fun HistoryLabel(
    historyLabelViewState: HistoryLabelViewState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    if (historyLabelViewState.isSelected) {
        Column(
            modifier = modifier
                .padding(5.dp)
                .width(intrinsicSize = IntrinsicSize.Max)
                .clickable(onClick = onClick)
        ) {
            Text(
                text = historyLabelViewState.labelText,
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
    }else{
        Text(
            text = historyLabelViewState.labelText,
            color = DarkGrey200
        )
    }
}

@Preview
@Composable
private fun HistoryLabelPreview(){
    HistoryLabel(
        historyLabelViewState = HistoryLabelViewState(isSelected = true, labelText = "Upcoming")
    ) {

    }
}