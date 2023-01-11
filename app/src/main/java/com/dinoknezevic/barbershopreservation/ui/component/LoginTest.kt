package com.dinoknezevic.barbershopreservation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.ui.theme.BackgroundDarkViolet
import com.dinoknezevic.barbershopreservation.ui.theme.spacing


@Composable
fun LoginTest(
    modifier: Modifier = Modifier
        //.background(BackgroundDarkViolet)
) {
    var email: String by rememberSaveable { mutableStateOf("") }
    var password: String by rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.large),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            //.padding(bottom = MaterialTheme.spacing.large)
            .clickable {
                focusManager.clearFocus()
            }
            .fillMaxHeight()
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.appicon),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.extraLarge)
        )
        LoginFields(
            loginFieldsViewState = LoginFieldsViewState(email, password),
            onEmailChange = { email = it },
            onPasswordChange = { password = it }
        )
        LoginButton(onClick = { })// viewmodel.login(email,password) odnosno FIREBASEAUTH
    }
}

@Preview
@Composable
private fun LoginTestPreview(

) {
    LoginTest()
}
