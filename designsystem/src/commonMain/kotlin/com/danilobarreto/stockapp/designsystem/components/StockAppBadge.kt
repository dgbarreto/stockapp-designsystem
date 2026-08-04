package com.danilobarreto.stockapp.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppShapes
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

enum class StockAppBadgeStyle { Success, Danger, Warning, Accent }

@Composable
fun StockAppBadge(text: String, style: StockAppBadgeStyle, modifier: Modifier = Modifier) {
    val (background, foreground) = when (style) {
        StockAppBadgeStyle.Success -> StockAppColors.bgSuccess to StockAppColors.textSuccess
        StockAppBadgeStyle.Danger -> StockAppColors.bgDanger to StockAppColors.textDanger
        StockAppBadgeStyle.Warning -> StockAppColors.bgWarning to StockAppColors.textWarning
        StockAppBadgeStyle.Accent -> StockAppColors.bgAccent to StockAppColors.textAccent
    }
    Text(
        text = text,
        style = StockAppTypography.labelMedium,
        color = foreground,
        modifier = modifier
            .background(background, shape = StockAppShapes.pillRadius)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
}