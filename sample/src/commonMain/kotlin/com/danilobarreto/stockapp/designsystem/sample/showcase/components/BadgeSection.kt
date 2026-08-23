package com.danilobarreto.stockapp.designsystem.sample.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.components.StockAppBadge
import com.danilobarreto.stockapp.designsystem.components.StockAppBadgeStyle
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseEntry

@Composable
fun BadgeSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Todos os estilos (StockAppBadgeStyle)",
            description = "Success, Danger, Warning, Accent lado a lado",
            code = """
                StockAppBadge("Compra", StockAppBadgeStyle.Success)
                StockAppBadge("Venda", StockAppBadgeStyle.Danger)
                StockAppBadge("Atenção", StockAppBadgeStyle.Warning)
                StockAppBadge("Info", StockAppBadgeStyle.Accent)
            """.trimIndent(),
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                StockAppBadge("Compra", StockAppBadgeStyle.Success)
                StockAppBadge("Venda", StockAppBadgeStyle.Danger)
                StockAppBadge("Atenção", StockAppBadgeStyle.Warning)
                StockAppBadge("Info", StockAppBadgeStyle.Accent)
            }
        }
    }
}
