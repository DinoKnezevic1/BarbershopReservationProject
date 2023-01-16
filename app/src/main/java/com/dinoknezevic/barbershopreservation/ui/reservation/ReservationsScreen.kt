package com.dinoknezevic.barbershopreservation.ui.reservation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.mock.BarberMock
import com.dinoknezevic.barbershopreservation.model.Service
import com.dinoknezevic.barbershopreservation.navigation.NavigationItem
import com.dinoknezevic.barbershopreservation.ui.component.ServiceItem
import com.dinoknezevic.barbershopreservation.ui.reservation.mapper.ReservationsScreenMapper
import com.dinoknezevic.barbershopreservation.ui.reservation.mapper.ReservationsScreenMapperImpl
import com.dinoknezevic.barbershopreservation.ui.theme.BackgroundDarkViolet
import com.dinoknezevic.barbershopreservation.ui.theme.LightOrange
import com.dinoknezevic.barbershopreservation.ui.theme.spacing
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

const val NUMBER_OF_COLUMNS = 1
private val reservationsScreenMapper: ReservationsScreenMapper = ReservationsScreenMapperImpl()

val reservationsScreenViewState =
    reservationsScreenMapper.toReservationsScreenViewState(BarberMock.getServices())

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReservationsRoute(
    viewModel: ReservationViewModel,
    onNavigateToPick: (String) -> Unit
) {
    val reservationsScreenViewState: ReservationsScreenViewState by viewModel.reservationsScreenViewState.collectAsState()
    //var reservationsScreenViewState by remember { mutableStateOf(reservationsScreenViewState) }
    //viewModel.populateServices()
    ReservationsScreen(
        reservationsScreenViewState = reservationsScreenViewState,
        onNavigateToPick = onNavigateToPick,
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReservationsScreen(
    reservationsScreenViewState: ReservationsScreenViewState,
    modifier: Modifier = Modifier.background(BackgroundDarkViolet),
    onNavigateToPick: (String) -> Unit
) {
    Column(
        modifier = modifier
            .padding(top = MaterialTheme.spacing.medium)
    ) {
        Greeting(modifier = modifier)
        BarberServices(
            modifier = modifier,
            barberServicesViewState = reservationsScreenViewState,
            onNavigateToPick = onNavigateToPick,
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatePickerPopup(

) {
    val dateDialogState = rememberMaterialDialogState()
    var pickedDate by remember { mutableStateOf(LocalDate.now()) }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MM dd yyyy")
                .format(pickedDate)
        }
    }
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
            Text(text = "Pick date")
        }
        Text(text = formattedDate)
    }
    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(text = "Ok") { }
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BarberServices(
    modifier: Modifier,
    barberServicesViewState: ReservationsScreenViewState,
    onNavigateToPick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(NUMBER_OF_COLUMNS),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(MaterialTheme.spacing.large)
    ) {

        items(barberServicesViewState.servicesList) { service ->
            val serviceItemViewState = Service(
                serviceId = service.serviceId,
                type = service.type,
                name = service.name,
                description = service.description,
                price = service.price
            )
            ServiceItem(
                serviceItemViewState = serviceItemViewState,
                onClick = {
                    onNavigateToPick(
                        NavigationItem.DateTimePickDestination.createNavigationRoute(
                            serviceItemViewState.serviceId
                        )
                    )
                },
            )
        }
        item {
            Divider(
                color = Color.White,
                thickness = MaterialTheme.spacing.extraSmall,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = MaterialTheme.spacing.large),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = modifier
                .weight(1f)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_mustache),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )
        }
        Box(
            modifier = modifier
                .weight(5f)
        ) {
            Text(
                text = stringResource(id = R.string.barbershop_slogan),
                style = MaterialTheme.typography.h5,
                color = LightOrange,
                textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = modifier
                .weight(1f)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_scissors_white),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )
        }

    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ReservationsScreenPreview(

) {
    ReservationsScreen(
        reservationsScreenViewState = reservationsScreenViewState,
        onNavigateToPick = { }
    )
}
