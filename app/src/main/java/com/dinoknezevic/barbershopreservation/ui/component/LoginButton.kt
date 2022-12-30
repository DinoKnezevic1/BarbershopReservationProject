package com.dinoknezevic.barbershopreservation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.ui.theme.LightViolet
import com.dinoknezevic.barbershopreservation.ui.theme.spacing

@Composable
fun LoginButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current
    /*
    Image(
        painter = painterResource(id = R.drawable.ic_checkmark),
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(id = R.dimen.login_button_size))
            .clip(shape = CircleShape)
            //.size(MaterialTheme.dimensions.loginButtonSize)
            .padding(MaterialTheme.spacing.large)
            .clickable {
                onClick()
                focusManager.clearFocus()
            }
            .background(color = LightViolet)
    )*/

    Image(
        painter = painterResource(id = R.drawable.ic_checkmark),
        contentDescription = "Favorite button",
        colorFilter = ColorFilter.tint(Color.Black),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(dimensionResource(id = R.dimen.login_button_size))
            .background(LightViolet, CircleShape)
            .padding(MaterialTheme.spacing.small)
            .clickable {
                onClick()
                focusManager.clearFocus()
            }
    )
}

@Preview
@Composable
private fun LoginButtonPreview(

) {
    LoginButton(onClick = { /*TODO*/ })
}
