package com.dinoknezevic.barbershopreservation.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.ui.theme.BlackViolet
import com.dinoknezevic.barbershopreservation.ui.theme.DarkGrey200
import com.dinoknezevic.barbershopreservation.ui.theme.dimensions
import com.dinoknezevic.barbershopreservation.ui.theme.spacing

data class FormCellViewState(
    val imagePath: Int,
    val placeholder: String
)

@Composable
fun FormCell(
    //on text change proslijedit lambdu?
    formCellViewState: FormCellViewState,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        singleLine = true,
        onValueChange = { onValueChange(it.toString()) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = stringResource(id = R.string.your_name)) },
        //placeholder = { Text(text = stringResource(id = R.string.name)) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = formCellViewState.imagePath),
                contentDescription = null,
                modifier = modifier
                    .padding(start = MaterialTheme.dimensions.formCellOffset)
            )
        },
        shape = RoundedCornerShape(MaterialTheme.dimensions.formCellRadius),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = BlackViolet,
            textColor = Color.White,
            leadingIconColor = Color.White,
            //placeholderColor = DarkGrey200,
            //disabledPlaceholderColor = DarkGrey200,
            unfocusedLabelColor = DarkGrey200,
            focusedLabelColor = DarkGrey200,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
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
    )
}

@Preview
@Composable
private fun FormCellPreview() {
    FormCell(FormCellViewState(
        R.drawable.ic_user,
        stringResource(id = R.string.name)
    ),
        onValueChange = {}
    )
}
