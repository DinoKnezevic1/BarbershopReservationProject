package com.dinoknezevic.barbershopreservation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.ui.theme.DarkGrey
import com.dinoknezevic.barbershopreservation.ui.theme.LightGrey
import com.dinoknezevic.barbershopreservation.ui.theme.dimensions
import com.dinoknezevic.barbershopreservation.ui.theme.spacing

data class ServiceItemViewState(
    val imagePath: Int,
    val name: String,
    val description: String,
    val price: String
)

@Composable
fun ServiceItem(
    modifier: Modifier = Modifier,
    serviceItemViewState: ServiceItemViewState
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
        modifier = modifier
            .padding(horizontal = MaterialTheme.spacing.large)
            .fillMaxWidth()
            .background(color = LightGrey, shape = RoundedCornerShape(MaterialTheme.spacing.small))
    ) {
        Box(
            modifier = modifier
                .weight(1f)
                .heightIn(min=MaterialTheme.dimensions.ServiceItemMinHeight)
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
        ) {
            ServiceNameDescription(serviceItemViewState)
        }
        Box(
            modifier = modifier
                .weight(2f)
                .heightIn(min=MaterialTheme.dimensions.ServiceItemMinHeight)
        ) {
            ServicePriceReserve(serviceItemViewState)
        }
    }
}

@Composable
fun ServicePriceReserve(serviceItemViewState: ServiceItemViewState) {
    Column(
        modifier = Modifier
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_btn_plus),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = serviceItemViewState.price,
            style = MaterialTheme.typography.h3,
            color = Color.Black
        )
    }
}

@Composable
fun ServiceNameDescription(serviceItemViewState: ServiceItemViewState) {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = serviceItemViewState.name,
            color = Color.Black,
            style = MaterialTheme.typography.h3
            //fontSize = MaterialTheme.typography.h3.fontSize,
        )
        Text(
            text = serviceItemViewState.description,
            color = DarkGrey,
            fontSize = 16.sp
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
            price = "40.55"
        )
    )
}
