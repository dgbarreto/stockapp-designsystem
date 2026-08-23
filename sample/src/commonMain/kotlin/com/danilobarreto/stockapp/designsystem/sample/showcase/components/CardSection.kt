package com.danilobarreto.stockapp.designsystem.sample.showcase.components

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
import com.danilobarreto.stockapp.designsystem.components.StockAppKeyValueRow
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseEntry
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

@Composable
fun CardSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Padrão (contentPadding = 16.dp)",
            code = """
                StockAppCard {
                    Text("PETR4", style = StockAppTypography.titleMedium, color = StockAppColors.textPrimary)
                    StockAppKeyValueRow("Preço", "R$ 38,42")
                    StockAppKeyValueRow("Dividend Yield", "12.4%")
                }
            """.trimIndent(),
        ) {
            StockAppCard {
                Text("PETR4", style = StockAppTypography.titleMedium, color = StockAppColors.textPrimary)
                Column(modifier = Modifier.padding(top = 8.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    StockAppKeyValueRow("Preço", "R$ 38,42")
                    StockAppKeyValueRow("Dividend Yield", "12.4%")
                }
            }
        }

        ShowcaseEntry(
            name = "contentPadding customizado",
            description = "contentPadding = 24.dp",
            code = """
                StockAppCard(contentPadding = 24.dp) {
                    Text("Preço-teto", style = StockAppTypography.titleMedium, color = StockAppColors.textPrimary)
                }
            """.trimIndent(),
        ) {
            StockAppCard(contentPadding = 24.dp) {
                Text("Preço-teto", style = StockAppTypography.titleMedium, color = StockAppColors.textPrimary)
            }
        }
    }
}
