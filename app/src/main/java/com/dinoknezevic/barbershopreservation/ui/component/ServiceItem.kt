package com.dinoknezevic.barbershopreservation.ui.component

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.ui.theme.*

data class ServiceItemViewState(
    val imagePath: Int,
    val name: String,
    val description: String,
    val price: String
)

@Composable
fun ServiceItem(
    modifier: Modifier = Modifier,
    serviceItemViewState: ServiceItemViewState,
    onClick:()->Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = MaterialTheme.spacing.large)//vertical only for preview
            .fillMaxWidth()
            .background(
                color = LightGrey,
                shape = RoundedCornerShape(MaterialTheme.spacing.medium)
            )
            .clickable { onClick() }//string or id(int) of the service?
    ) {
        Box(
            modifier = modifier
                .weight(2f)
                .heightIn(min=MaterialTheme.dimensions.ServiceItemMinHeight)
                .padding(MaterialTheme.spacing.small)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = serviceItemViewState.imagePath),
                contentDescription = null,
                modifier = modifier
            )
        }
        Box(
            modifier = modifier
                .weight(4f)
                .heightIn(min=MaterialTheme.dimensions.ServiceItemMinHeight)
                .padding(MaterialTheme.spacing.small)
        ) {
            ServiceNameDescription(serviceItemViewState)
        }
        Box(
            modifier = modifier
                .weight(2f)
                .padding(MaterialTheme.spacing.small)
        ) {
            Text(
                text = serviceItemViewState.price,
                fontSize= 18.sp,
                fontWeight= FontWeight.Bold,
                color = LightOrange,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ServiceNameDescription(serviceItemViewState: ServiceItemViewState) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraSmall),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = serviceItemViewState.name,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight= FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = serviceItemViewState.description,
            color = DarkGrey,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun ServiceItemPreview(

) {
    ServiceItem(
        serviceItemViewState = ServiceItemViewState(
            imagePath = R.drawable.ic_haircut,
            name = stringResource(
                id = R.string.modern_haircut
            ),
            description = "Maaa brtee fade najjaca stvar ikad predobro je vjeruj mi",
            price = "7.65$"
        ), onClick = {}
    )
}
