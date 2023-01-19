package com.dinoknezevic.barbershopreservation.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.navigation.HOME_ROUTE
import com.dinoknezevic.barbershopreservation.ui.component.LoginButton
import com.dinoknezevic.barbershopreservation.ui.component.LoginFields
import com.dinoknezevic.barbershopreservation.ui.component.LoginFieldsViewState
import com.dinoknezevic.barbershopreservation.ui.theme.spacing
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun LoginRoute(
    navController: NavController
) {
    var email: String by rememberSaveable { mutableStateOf("") }
    var password: String by rememberSaveable { mutableStateOf("") }

    if(Firebase.auth.currentUser!=null){
        navController.navigate(HOME_ROUTE)
    }else
    {
        LoginScreen(
            email = email,
            password = password,
            onLNavigateToHome = {
                Firebase.auth.createUserWithEmailAndPassword(email,password)
                navController.navigate(HOME_ROUTE)
            },
            onEmailChange = { email = it },
            onPasswordChange = { password = it })
    }

}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLNavigateToHome: () -> Unit
) {
    //var email: String by rememberSaveable { mutableStateOf("") }
    //var password: String by rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.large),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
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
            onEmailChange = { onEmailChange(it) },
            onPasswordChange = { onPasswordChange(it) }
        )
        LoginButton(
            onClick = {
                onLNavigateToHome()
            }
        )
    }
}
