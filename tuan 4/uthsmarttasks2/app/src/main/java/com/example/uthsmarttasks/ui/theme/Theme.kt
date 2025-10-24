package com.example.uthsmarttasks.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// 🎨 Màu sắc chủ đạo đồng bộ với logo UTH và nền trắng tinh của OnBoard1
val AppPrimaryBlue = Color(0xFF1565C0)     // Xanh dương chủ đạo (logo UTH)
val AppLightBlue = Color(0xFF5E92F3)       // Xanh nhạt nhấn phụ
val AppBackgroundWhite = Color(0xFFFFFFFF) // ✅ Trắng tinh như OnBoard1
val AppTextDark = Color(0xFF1A1A1A)        // Màu chữ chính
val AppGray = Color(0xFF9E9E9E)            // Màu phụ / viền

// 🌞 Giao diện sáng
private val LightColorScheme = lightColorScheme(
    primary = AppPrimaryBlue,
    onPrimary = Color.White,
    secondary = AppLightBlue,
    onSecondary = Color.White,
    background = AppBackgroundWhite, // ✅ Giống OnBoard1
    onBackground = AppTextDark,
    surface = AppBackgroundWhite,    // ✅ Giống OnBoard1
    onSurface = AppTextDark
)

// 🌙 Giao diện tối (nếu muốn thêm sau)
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
