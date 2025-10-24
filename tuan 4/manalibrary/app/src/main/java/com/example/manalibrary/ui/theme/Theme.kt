package com.example.manalibrary.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = PrimaryBlue,
    secondary = DarkRed,
    background = BackgroundWhite,
    surface = LightGray,
    onPrimary = BackgroundWhite,
    onSecondary = BackgroundWhite,
    onBackground = TextGray,
    onSurface = TextGray
)

@Composable
fun ManaLibraryTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
