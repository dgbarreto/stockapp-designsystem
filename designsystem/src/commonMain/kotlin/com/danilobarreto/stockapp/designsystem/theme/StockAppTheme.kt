package com.danilobarreto.stockapp.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val StockAppColorScheme = lightColorScheme(
    background = StockAppColors.surface1,
    surface = StockAppColors.surface2,
    onSurface = StockAppColors.textPrimary,
    onBackground = StockAppColors.textPrimary,
    primary = StockAppColors.textAccent,
    onPrimary = StockAppColors.surface2,
    secondary = StockAppColors.textSecondary,
    error = StockAppColors.textDanger,
    onError = StockAppColors.surface2,
    outline = StockAppColors.border,
)

private val StockAppTypographyScheme = Typography(
    titleLarge = StockAppTypography.titleLarge,
    titleMedium = StockAppTypography.titleMedium,
    bodyMedium = StockAppTypography.bodyMedium,
    labelMedium = StockAppTypography.labelMedium,
    labelSmall = StockAppTypography.labelSmall,
)

@Composable
fun StockAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = StockAppColorScheme,
        typography = StockAppTypographyScheme,
        shapes = MaterialTheme.shapes.copy(medium = StockAppShapes.cardRadius),
        content = content,
    )
}