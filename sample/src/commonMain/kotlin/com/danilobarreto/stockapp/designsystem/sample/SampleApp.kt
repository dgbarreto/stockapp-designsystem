package com.danilobarreto.stockapp.designsystem.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.components.StockAppCard
import com.danilobarreto.stockapp.designsystem.components.StockAppErrorBanner
import com.danilobarreto.stockapp.designsystem.components.StockAppKeyValueRow
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

@Composable
fun SampleApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StockAppColors.surface1)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("StockApp Design System", style = StockAppTypography.titleLarge, color = StockAppColors.textPrimary)

        StockAppCard {
            Text("StockAppCard + StockAppKeyValueRow", style = StockAppTypography.titleMedium, color = StockAppColors.textPrimary)
            Column(modifier = Modifier.padding(top = 12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                StockAppKeyValueRow("P/L", "8.42")
                StockAppKeyValueRow("ROE", "18.6%")
                StockAppKeyValueRow("Dívida líq./EBITDA", "1.2")
            }
        }

        StockAppErrorBanner("Exemplo de mensagem de erro")
    }
}