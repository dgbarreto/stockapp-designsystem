package com.danilobarreto.stockapp.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danilobarreto.stockapp.designsystem.icons.StockAppIcons
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppShapes
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

@Composable
fun StockAppStepper(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    min: Int = 1,
    max: Int = Int.MAX_VALUE,
    step: Int = 1,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        StepperButton(
            icon = StockAppIcons.Minus,
            contentDescription = "Diminuir",
            enabled = value > min,
            onClick = { onValueChange((value - step).coerceAtLeast(min)) },
        )
        Text(
            text = value.toString(),
            style = StockAppTypography.headerTitle.copy(fontSize = 22.sp),
            color = StockAppColors.textPrimary,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f),
        )
        StepperButton(
            icon = StockAppIcons.Plus,
            contentDescription = "Aumentar",
            enabled = value < max,
            onClick = { onValueChange((value + step).coerceAtMost(max)) },
        )
    }
}

@Composable
private fun StepperButton(
    icon: ImageVector,
    contentDescription: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(34.dp)
            .background(StockAppColors.primaryTint, shape = StockAppShapes.controlRadius)
            .clickable(enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = StockAppColors.primaryDeep,
            modifier = Modifier.size(18.dp),
        )
    }
}