package com.dinoknezevic.barbershopreservation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = LightOrange,
    primaryVariant = DarkOrange,
    secondary = LightViolet,
    background = BackgroundDarkViolet,
    onPrimary = LightGrey
)

private val LightColorPalette = lightColors(
    primary = LightOrange,
    primaryVariant = DarkOrange,
    secondary = LightViolet,
    background = BackgroundDarkViolet,
    onPrimary = LightGrey

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BarbershopReservationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    if(darkTheme){
        systemUiController.setSystemBarsColor(
            color = DarkOrange
        )
    }else{
        systemUiController.setSystemBarsColor(
            color = DarkOrange
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}