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
import com.danilobarreto.stockapp.designsystem.components.StockAppStepper
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseEntry

@Composable
fun StepperSection(modifier: Modifier = Modifier) {
    var quantity by remember { mutableStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Quantidade (interativo, min = 1, max = 10)",
            description = "value = $quantity",
            code = """
                StockAppStepper(
                    value = $quantity,
                    onValueChange = { quantity = it },
                    min = 1,
                    max = 10,
                )
            """.trimIndent(),
        ) {
            StockAppStepper(
                value = quantity,
                onValueChange = { quantity = it },
                min = 1,
                max = 10,
            )
        }
    }
}
