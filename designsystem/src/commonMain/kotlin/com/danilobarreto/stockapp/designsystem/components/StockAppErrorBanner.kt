package com.danilobarreto.stockapp.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppShapes
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

@Composable
fun StockAppErrorBanner(message: String, modifier: Modifier = Modifier){
    Text(
        message,
        style = StockAppTypography.bodyMedium,
        color = StockAppColors.textDanger,
        modifier = modifier
            .fillMaxWidth()
            .background(StockAppColors.bgDanger, shape = StockAppShapes.cardRadius)
            .padding(12.dp)
    )
}