package com.danilobarreto.stockapp.designsystem.sample.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.components.StockAppPrimaryButton
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseEntry
import kotlinx.coroutines.delay

@Composable
fun PrimaryButtonSection(modifier: Modifier = Modifier) {
    // StockAppPrimaryButton disables itself while loading (enabled && !loading), so a plain
    // toggle would get stuck on the first click. Simulate a real async action instead: clicking
    // starts the spinner, and it reverts on its own — the interactive part the user actually sees.
    var isLoading by remember { mutableStateOf(false) }
    LaunchedEffect(isLoading) {
        if (isLoading) {
            delay(1200)
            isLoading = false
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Padrão (enabled = true)",
            code = """
                StockAppPrimaryButton(
                    text = "Entrar",
                    onClick = { },
                )
            """.trimIndent(),
        ) {
            StockAppPrimaryButton(text = "Entrar", onClick = { })
        }

        ShowcaseEntry(
            name = "Desabilitado",
            description = "enabled = false",
            code = """
                StockAppPrimaryButton(
                    text = "Entrar",
                    onClick = { },
                    enabled = false,
                )
            """.trimIndent(),
        ) {
            StockAppPrimaryButton(text = "Entrar", onClick = { }, enabled = false)
        }

        ShowcaseEntry(
            name = "Loading (interativo — clique para simular um envio)",
            description = "loading = $isLoading",
            code = """
                StockAppPrimaryButton(
                    text = "Entrar",
                    onClick = { isLoading = true },
                    loading = $isLoading,
                )
            """.trimIndent(),
        ) {
            StockAppPrimaryButton(
                text = "Entrar",
                onClick = { isLoading = true },
                loading = isLoading,
            )
        }
    }
}
