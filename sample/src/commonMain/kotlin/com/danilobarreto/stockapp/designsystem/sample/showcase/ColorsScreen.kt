package com.danilobarreto.stockapp.designsystem.sample.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppShapes
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

private data class ColorSwatch(val propertyName: String, val hex: String, val color: Color)

// Grouped exactly as in theme/Color.kt (StockAppColors): section comments become group titles.
private val surfaceSwatches = listOf(
    ColorSwatch("surface0", "#ECEAE3", StockAppColors.surface0),
    ColorSwatch("surface1", "#F7F6F2", StockAppColors.surface1),
    ColorSwatch("surface2", "#FFFFFF", StockAppColors.surface2),
)

private val textSwatches = listOf(
    ColorSwatch("textPrimary", "#1A1A1A", StockAppColors.textPrimary),
    ColorSwatch("textSecondary", "#5F5E5A", StockAppColors.textSecondary),
    ColorSwatch("textMuted", "#888780", StockAppColors.textMuted),
    ColorSwatch("textSuccess", "#27500A", StockAppColors.textSuccess),
    ColorSwatch("textDanger", "#791F1F", StockAppColors.textDanger),
    ColorSwatch("textAccent", "#0C447C", StockAppColors.textAccent),
    ColorSwatch("textWarning", "#633806", StockAppColors.textWarning),
)

private val semanticBackgroundSwatches = listOf(
    ColorSwatch("bgSuccess", "#EAF3DE", StockAppColors.bgSuccess),
    ColorSwatch("bgDanger", "#FCEBEB", StockAppColors.bgDanger),
    ColorSwatch("bgAccent", "#E6F1FB", StockAppColors.bgAccent),
    ColorSwatch("bgWarning", "#FAEEDA", StockAppColors.bgWarning),
)

private val borderSwatches = listOf(
    ColorSwatch("border", "#E2DFD6", StockAppColors.border),
)

@Composable
fun ColorsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(28.dp),
    ) {
        ShowcaseGroup("Superfícies") { SwatchGrid(surfaceSwatches) }
        ShowcaseGroup("Texto") { SwatchGrid(textSwatches) }
        ShowcaseGroup("Fundos semânticos (badges, alertas)") { SwatchGrid(semanticBackgroundSwatches) }
        ShowcaseGroup("Borda") { SwatchGrid(borderSwatches) }
    }
}

@Composable
private fun SwatchGrid(swatches: List<ColorSwatch>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        swatches.forEach { swatch -> SwatchCell(swatch) }
    }
}

@Composable
private fun SwatchCell(swatch: ColorSwatch) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(swatch.color, shape = StockAppShapes.cardRadius)
                .border(1.dp, StockAppColors.border, shape = StockAppShapes.cardRadius)
        )
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text("StockAppColors.${swatch.propertyName}", style = StockAppTypography.bodyMedium, color = StockAppColors.textPrimary)
            Text(swatch.hex, style = StockAppTypography.labelSmall, color = StockAppColors.textSecondary)
        }
    }
}
