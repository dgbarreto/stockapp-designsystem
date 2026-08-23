package com.danilobarreto.stockapp.designsystem.sample.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.danilobarreto.stockapp.designsystem.components.StockAppSegmentedControl
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseEntry

private val periods = listOf("1D", "1M", "1A", "Tudo")

@Composable
fun SegmentedControlSection(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Período (interativo — toque para trocar)",
            description = "selectedIndex = $selectedIndex (\"${periods[selectedIndex]}\")",
            code = """
                StockAppSegmentedControl(
                    options = listOf("1D", "1M", "1A", "Tudo"),
                    selectedIndex = $selectedIndex,
                    onOptionSelected = { selectedIndex = it },
                )
            """.trimIndent(),
        ) {
            StockAppSegmentedControl(
                options = periods,
                selectedIndex = selectedIndex,
                onOptionSelected = { selectedIndex = it },
            )
        }
    }
}
