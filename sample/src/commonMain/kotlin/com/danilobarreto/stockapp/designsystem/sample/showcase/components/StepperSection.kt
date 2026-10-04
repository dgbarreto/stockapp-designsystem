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
    var lot by remember { mutableStateOf(100) }
    var units by remember { mutableStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Quantidade com limite (min = 1, max = 10)",
            description = "value = $quantity — digite 50 e saia do campo: volta pro máximo (10). Apague tudo e saia: volta pro mínimo (1).",
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

        ShowcaseEntry(
            name = "Ação — lote padrão (step = 100)",
            description = "value = $lot — botões andam de 100 em 100; tocar no número seleciona tudo pra digitar um valor fracionário (ex.: 150).",
            code = """
                StockAppStepper(
                    value = $lot,
                    onValueChange = { lot = it },
                    min = 1,
                    step = 100,
                )
            """.trimIndent(),
        ) {
            StockAppStepper(
                value = lot,
                onValueChange = { lot = it },
                min = 1,
                step = 100,
            )
        }

        ShowcaseEntry(
            name = "FII — unitário (step = 1)",
            description = "value = $units — sem lote: botões de 1 em 1, número também editável.",
            code = """
                StockAppStepper(
                    value = $units,
                    onValueChange = { units = it },
                    min = 1,
                    step = 1,
                )
            """.trimIndent(),
        ) {
            StockAppStepper(
                value = units,
                onValueChange = { units = it },
                min = 1,
                step = 1,
            )
        }
    }
}
