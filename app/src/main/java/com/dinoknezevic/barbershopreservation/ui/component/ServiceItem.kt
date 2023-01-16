package com.dinoknezevic.barbershopreservation.ui.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import com.dinoknezevic.barbershopreservation.model.Service
import com.dinoknezevic.barbershopreservation.model.ServiceType
import com.dinoknezevic.barbershopreservation.ui.theme.*
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class ServiceItemViewState(
    val id:Int,
    val type: ServiceType,
    val name: String,
    val description: String,
    val price: String
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ServiceItem(
    modifier: Modifier = Modifier,
    serviceItemViewState: Service,
    onClick:()->Unit
) {
    /*
    val dateDialogState = rememberMaterialDialogState()
    var pickedDate by remember { mutableStateOf(LocalDate.now()) }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MM dd yyyy")
                .format(pickedDate)
        }
    }
    */
    //Column {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                //.padding(horizontal = MaterialTheme.spacing.large)//vertical only for preview
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
                    .heightIn(min = MaterialTheme.dimensions.ServiceItemMinHeight)
                    .padding(MaterialTheme.spacing.small)
            ) {
                Image(
                    imageVector = when(serviceItemViewState.type){
                        ServiceType.HAIRCUT->ImageVector.vectorResource(id = R.drawable.ic_haircut)
                        ServiceType.BEARD -> ImageVector.vectorResource(id=R.drawable.ic_beard)
                        ServiceType.HAIRCUT_AND_BEARD -> ImageVector.vectorResource(id=R.drawable.ic_haircut_beard)
                    },
                    //imageVector = ImageVector.vectorResource(id = serviceItemViewState.imagePath),
                    contentDescription = null,
                    modifier = modifier
                )
            }
            Box(
                modifier = modifier
                    .weight(4f)
                    .heightIn(min = MaterialTheme.dimensions.ServiceItemMinHeight)
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
        /*
        Box(modifier = modifier){
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
                    allowedDateValidator = {
                        it.dayOfMonth % 2 == 1
                    }
                ) {
                    pickedDate = it
                }
            }
        }
         */
    //}

}

@Composable
fun ServiceNameDescription(serviceItemViewState: Service) {
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

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ServiceItemPreview(

) {
    ServiceItem(
        serviceItemViewState = Service(
            serviceId=1,
            type=ServiceType.HAIRCUT,
            //imagePath = R.drawable.ic_haircut,
            name = stringResource(
                id = R.string.modern_haircut
            ),
            description = "Maaa brtee fade najjaca stvar ikad predobro je vjeruj mi",
            price = "7.65$"
        )
    ) {}
}
