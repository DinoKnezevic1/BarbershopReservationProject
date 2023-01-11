package com.dinoknezevic.barbershopreservation.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.ui.theme.*

data class LoginFieldsViewState(
    val email: String,
    val password: String
)

@Composable
fun LoginFields(
    loginFieldsViewState: LoginFieldsViewState,
    modifier: Modifier = Modifier,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
    ) {
        TextField(
            value = loginFieldsViewState.email,
            onValueChange = onEmailChange,
            singleLine = true,
            //placeholder = { Text(text = stringResource(id = R.string.e_mail)) },
            label = { Text(text = stringResource(id = R.string.e_mail)) },
            shape = RoundedCornerShape(MaterialTheme.dimensions.loginFieldRadius),
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Center,
                //fontSize =
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = BlackViolet,
                textColor = Color.White,
                //placeholderColor = DarkGrey200,
                //disabledPlaceholderColor = DarkGrey200,
                unfocusedLabelColor = DarkGrey200,
                focusedLabelColor = DarkGrey200,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            modifier = modifier
                //.clip(MaterialTheme.shapes.large)
                .padding(
                    paddingValues = PaddingValues(
                        horizontal = MaterialTheme.spacing.large,
                        vertical = MaterialTheme.spacing.small
                    )
                )
                .fillMaxWidth()
                .border(
                    width = MaterialTheme.dimensions.loginFieldBorder,
                    color = LightOrange,
                    shape = RoundedCornerShape(MaterialTheme.dimensions.loginFieldRadius)
                )
        )
        TextField(
            value = loginFieldsViewState.password,
            onValueChange = onPasswordChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Center,
                //fontSize =
            ),
            //placeholder = { Text(text = stringResource(id = R.string.password)) },
            label = { Text(text = stringResource(id = R.string.password)) },
            shape = RoundedCornerShape(MaterialTheme.dimensions.loginFieldRadius),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = BlackViolet,
                textColor = Color.White,
                //placeholderColor = DarkGrey200,
                //disabledPlaceholderColor = DarkGrey200,
                unfocusedLabelColor = DarkGrey200,
                focusedLabelColor = DarkGrey200,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            modifier = modifier
                //.clip(MaterialTheme.shapes.large)
                .padding(
                    paddingValues = PaddingValues(
                        horizontal = MaterialTheme.spacing.large,
                        vertical = MaterialTheme.spacing.small
                    )
                )
                .fillMaxWidth()
                .border(
                    width = MaterialTheme.dimensions.loginFieldBorder,
                    color = LightOrange,
                    shape = RoundedCornerShape(MaterialTheme.dimensions.loginFieldRadius)
                )
        )
    }

}

@Preview
@Composable
private fun LoginFieldsPreview(

) {
    LoginFields(
        loginFieldsViewState = LoginFieldsViewState("email test", "password123"),
        onEmailChange = {},
        onPasswordChange = {})
}
