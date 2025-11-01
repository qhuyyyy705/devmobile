package com.example.demofirebase.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val AppPrimaryBlue = Color(0xFF1565C0)
val AppLightBlue = Color(0xFF5E92F3)
val AppBackgroundWhite = Color(0xFFFFFFFF)
val AppTextDark = Color(0xFF1A1A1A)
val AppGray = Color(0xFF9E9E9E)

private val LightColorScheme = lightColorScheme(
    primary = AppPrimaryBlue,
    onPrimary = Color.White,
    secondary = AppLightBlue,
    onSecondary = Color.White,
    background = AppBackgroundWhite,
    onBackground = AppTextDark,
    surface = AppBackgroundWhite,
    onSurface = AppTextDark
)

private val DarkColorScheme = darkColorScheme(
    primary = AppPrimaryBlue,
    onPrimary = Color.White,
    secondary = AppLightBlue,
    onSecondary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White
)

@Composable
fun UTHSmartTasksTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}