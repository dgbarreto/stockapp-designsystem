package com.danilobarreto.stockapp.designsystem.sample.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.components.StockAppChip
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseEntry

private val filterOptions = listOf("Todos", "Ações", "FIIs", "Renda fixa")

@Composable
fun ChipSection(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Filtro (interativo — toque para selecionar)",
            description = "selected = índice ${selectedIndex}",
            code = """
                filterOptions.forEachIndexed { index, label ->
                    StockAppChip(
                        text = label,
                        selected = index == selectedIndex,
                        onClick = { selectedIndex = index },
                    )
                }
            """.trimIndent(),
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                filterOptions.forEachIndexed { index, label ->
                    StockAppChip(
                        text = label,
                        selected = index == selectedIndex,
                        onClick = { selectedIndex = index },
                    )
                }
            }
        }
    }
}
