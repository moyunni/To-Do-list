package com.quwy.to_dolist.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = FluxOrange,
    background = FluxDarkBackground,
    surface = FluxDarkSurface,
    onPrimary = FluxBrownText,
    onBackground = Color(0xFFE6DED8),
    onSurface = Color(0xFFE6DED8)
)

private val LightColorScheme = lightColorScheme(
    primary = FluxOrange,
    background = FluxBackgroundLight,
    surface = Color.White,
    onPrimary = Color.White,
    onBackground = FluxBrownText,
    onSurface = FluxBrownText
)

@Composable
fun ToDoListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}