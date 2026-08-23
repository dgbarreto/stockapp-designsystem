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

private fun FontWeight.label(): String = when (this) {
    FontWeight.Light -> "Light"
    FontWeight.Normal -> "Normal"
    FontWeight.Medium -> "Medium"
    FontWeight.SemiBold -> "SemiBold"
    FontWeight.Bold -> "Bold"
    FontWeight.ExtraBold -> "ExtraBold"
    else -> toString()
}

@Composable
fun TypographyScreen(modifier: Modifier = Modifier) {
    // StockAppTypography's properties are `@Composable get()` (they resolve Outfit/Bricolage font
    // resources), so the sample list has to be built here, inside a composable, rather than as a
    // top-level val.
    val typographySamples = listOf(
        TypographySample("titleLarge", "títulos de tela", StockAppTypography.titleLarge),
        TypographySample("titleMedium", "títulos de seção / nome do ativo", StockAppTypography.titleMedium),
        TypographySample("bodyMedium", "item de lista, corpo", StockAppTypography.bodyMedium),
        TypographySample("labelMedium", "labels, badges, chips", StockAppTypography.labelMedium),
        TypographySample("labelSmall", "metadados (qtd., PM)", StockAppTypography.labelSmall),
        TypographySample("displayXLarge", "patrimônio total (home)", StockAppTypography.displayXLarge),
        TypographySample("displayLarge", "preço do ativo", StockAppTypography.displayLarge),
        TypographySample("displayMedium", "total da carteira", StockAppTypography.displayMedium),
        TypographySample("headerTitle", "título dentro do header colorido", StockAppTypography.headerTitle),
        TypographySample("buttonLabel", "texto de botão primário", StockAppTypography.buttonLabel),
        TypographySample("bodySmall", "texto secundário", StockAppTypography.bodySmall),
        TypographySample("labelTable", "label de tabela dentro de card", StockAppTypography.labelTable),
    )

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
