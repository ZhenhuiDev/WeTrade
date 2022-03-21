package com.sleep.wetrade.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Yellow,
    onPrimary = Gray900,
    background = Gray900,
    onBackground = Color.White,
    surface = Gray700,
    onSurface = Color.White,
)

private val LightColorPalette = lightColors(
    primary = Yellow,
    onPrimary = Gray900,
    background = Purple,
    onBackground = Color.White,
    surface = Color.White,
    onSurface = Gray900,
)

@Composable
fun WeTradeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = WeTradeTypography,
        shapes = Shapes,
        content = content
    )
}