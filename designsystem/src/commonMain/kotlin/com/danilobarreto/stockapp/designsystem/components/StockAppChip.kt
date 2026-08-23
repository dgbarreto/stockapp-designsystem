package com.danilobarreto.stockapp.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppShapes
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

@Composable
fun StockAppChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val background = if (selected) StockAppColors.primary else StockAppColors.surface2
    val contentColor = if (selected) StockAppColors.onPrimary else StockAppColors.textPrimary

    Text(
        text = text,
        style = StockAppTypography.labelMedium,
        color = contentColor,
        modifier = modifier
            .background(background, shape = StockAppShapes.pillRadius)
            .let { base ->
                if (!selected) {
                    base.border(1.5.dp, StockAppColors.border, shape = StockAppShapes.pillRadius)
                } else base
            }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ) { onClick() }
            .padding(horizontal = 14.dp, vertical = 8.dp),
    )
}