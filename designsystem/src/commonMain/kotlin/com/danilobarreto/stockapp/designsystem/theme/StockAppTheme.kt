package com.danilobarreto.stockapp.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val StockAppColorScheme = lightColorScheme(
    primary = StockAppColors.textAccent,
    onPrimary = StockAppColors.surface2,
    primaryContainer = StockAppColors.bgAccent,
    onPrimaryContainer = StockAppColors.textAccent,
    secondary = StockAppColors.textSecondary,
    onSecondary = StockAppColors.surface2,
    background = StockAppColors.surface1,
    onBackground = StockAppColors.textPrimary,
    surface = StockAppColors.surface2,
    onSurface = StockAppColors.textPrimary,
    surfaceVariant = StockAppColors.surface0,
    onSurfaceVariant = StockAppColors.textSecondary,
    error = StockAppColors.textDanger,
    onError = StockAppColors.surface2,
    errorContainer = StockAppColors.bgDanger,
    onErrorContainer = StockAppColors.textDanger,
    outline = StockAppColors.border,
)

private val StockAppTypographyScheme = Typography(
    titleLarge = StockAppTypography.titleLarge,
    titleMedium = StockAppTypography.titleMedium,
    bodyMedium = StockAppTypography.bodyMedium,
    labelMedium = StockAppTypography.labelMedium,
    labelSmall = StockAppTypography.labelSmall,
)

private val StockAppShapeScheme = Shapes(
    medium = StockAppShapes.cardRadius,
)

@Composable
fun StockAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = StockAppColorScheme,
        typography = StockAppTypographyScheme,
        shapes = StockAppShapeScheme,
        content = content,
    )
}