package com.dealabs.floxen.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush

@Composable
fun FloxenSocialTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = androidx.compose.material3.darkColorScheme(
            primary = FloxenPrimary,
            secondary = FloxenSecondary,
            tertiary = FloxenTertiary,
            background = FloxenBackground,
            surface = FloxenSurface,
            onPrimary = TextPrimary,
            onSecondary = TextPrimary,
            onBackground = TextPrimary,
            onSurface = TextPrimary
        ),
        typography = Typography,
        content = content
    )
}

val FloxenGradient = Brush.linearGradient(
    colors = listOf(GradientStart, GradientMiddle, GradientEnd)
)