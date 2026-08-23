package com.danilobarreto.stockapp.designsystem.sample.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.components.StockAppKeyValueRow
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseEntry

@Composable
fun KeyValueRowSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Linhas label/valor",
            description = "Cada chamada renderiza um Row com label à esquerda e valor à direita",
            code = """
                StockAppKeyValueRow("P/L", "8.42")
                StockAppKeyValueRow("ROE", "18.6%")
                StockAppKeyValueRow("Dívida líq./EBITDA", "1.2")
            """.trimIndent(),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                StockAppKeyValueRow("P/L", "8.42")
                StockAppKeyValueRow("ROE", "18.6%")
                StockAppKeyValueRow("Dívida líq./EBITDA", "1.2")
            }
        }
    }
}
