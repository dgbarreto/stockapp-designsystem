package com.danilobarreto.stockapp.designsystem.sample.showcase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

private data class TypographySample(val propertyName: String, val usage: String, val style: TextStyle)

// Every value declared in theme/Typography.kt (StockAppTypography), in source order.
private val typographySamples = listOf(
    TypographySample("titleLarge", "ex.: valor do patrimônio", StockAppTypography.titleLarge),
    TypographySample("titleMedium", "títulos de seção", StockAppTypography.titleMedium),
    TypographySample("bodyMedium", "nome/valor do ativo", StockAppTypography.bodyMedium),
    TypographySample("labelMedium", "labels, badges", StockAppTypography.labelMedium),
    TypographySample("labelSmall", "metadados (qtd., PM)", StockAppTypography.labelSmall),
)

private fun FontWeight.label(): String = when (this) {
    FontWeight.Normal -> "Normal"
    FontWeight.Medium -> "Medium"
    else -> toString()
}

@Composable
fun TypographyScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        typographySamples.forEach { sample ->
            val weight = sample.style.fontWeight ?: FontWeight.Normal
            ShowcaseEntry(
                name = "StockAppTypography.${sample.propertyName}",
                description = "${sample.style.fontSize} · ${weight.label()} — ${sample.usage}",
                code = "Text(\n    text = \"Aa Bufunfa+ 123\",\n    style = StockAppTypography.${sample.propertyName},\n)",
            ) {
                Text(
                    text = "Aa Bufunfa+ 123",
                    style = sample.style,
                    color = StockAppColors.textPrimary,
                )
            }
        }
    }
}
