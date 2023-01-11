package com.dinoknezevic.barbershopreservation.ui.home

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.navigation.NavigationItem
import com.dinoknezevic.barbershopreservation.ui.theme.*

const val SERVICE_ID = 9999

@Composable
fun HomeRoute(
    onNavigateToReservations: (String) -> Unit
) {
    HomeScreen(
        onNavigateToReservations = onNavigateToReservations
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToReservations: (String) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .padding(MaterialTheme.spacing.large)
            .fillMaxSize()
        //.background(color = BackgroundDarkViolet)
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_gentleman),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .background(
                    color = LightBlue,
                    shape = RoundedCornerShape(MaterialTheme.spacing.large)
                )
        )
        WelcomeText()
        ReservationButton(onNavigateToReservations = onNavigateToReservations)
    }
}

@Composable
fun WelcomeText(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
        //.padding(horizontal = MaterialTheme.spacing.large)
    ) {
        Text(
            text = stringResource(id = R.string.welcome_sir),
            style = MaterialTheme.typography.h4,
            color = Color.Black
        )
        Text(
            text = stringResource(id = R.string.are_you_ready),
            fontSize = 16.sp,
            color = DarkGrey200
        )
        Text(
            text = stringResource(id = R.string.we_certainly_are),
            fontSize = 20.sp,
            color = Color.Black
        )

    }
}

@Composable
fun ReservationButton(
    modifier: Modifier = Modifier,
    onNavigateToReservations: (String) -> Unit
) {
    Box(
        modifier = modifier
            .background(
                color = LightViolet,
                shape = RoundedCornerShape(MaterialTheme.spacing.medium)
            )
            .clickable {

                onNavigateToReservations(
                    NavigationItem.ReservationsDestination.createNavigationRoute(SERVICE_ID)
                )

            }//navigate
    ) {
        Text(
            text = stringResource(id = R.string.book_appointment),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = modifier
                .padding(MaterialTheme.spacing.small)
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview(

) {
    HomeScreen {
    }
}
