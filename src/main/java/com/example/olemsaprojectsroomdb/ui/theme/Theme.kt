package com.example.olemsaprojectsroomdb.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = GreenPrimary,
    secondary = GreenSecondary,
    background = BackgroundColor,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = TextColor,
    onSurface = TextColor,
)

private val DarkColors = darkColorScheme(
    primary = GreenPrimary,
    secondary = GreenSecondary,
    background = GrayPrimary,
    surface = GraySecondary,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun BudgetAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = AppShapes, // from Shapes.kt
        content = content
    )
}
