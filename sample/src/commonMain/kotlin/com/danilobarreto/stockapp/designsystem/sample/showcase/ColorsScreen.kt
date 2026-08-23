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

// Grouped exactly as in theme/Color.kt (StockAppColors, tema "Framboesa"): section comments
// become group titles. surface0 was removed by the rebrand (#20); bg/divider/segTrack/
// sheetHandle are new.
private val brandSwatches = listOf(
    ColorSwatch("primary", "#C6155C", StockAppColors.primary),
    ColorSwatch("primaryDeep", "#6E0A32", StockAppColors.primaryDeep),
    ColorSwatch("primaryTint", "#FDE8F0", StockAppColors.primaryTint),
    ColorSwatch("onPrimary", "#FFFFFF", StockAppColors.onPrimary),
)

private val surfaceSwatches = listOf(
    ColorSwatch("bg", "#F7F2F4", StockAppColors.bg),
    ColorSwatch("surface1", "#F7F2F4", StockAppColors.surface1),
    ColorSwatch("surface2", "#FFFFFF", StockAppColors.surface2),
)

private val textSwatches = listOf(
    ColorSwatch("textPrimary", "#1A1014", StockAppColors.textPrimary),
    ColorSwatch("textSecondary", "#6B5860", StockAppColors.textSecondary),
    ColorSwatch("textMuted", "#A79E96", StockAppColors.textMuted),
    ColorSwatch("textSuccess", "#1F7A47", StockAppColors.textSuccess),
    ColorSwatch("textDanger", "#B3251F", StockAppColors.textDanger),
    ColorSwatch("textAccent", "#C6155C", StockAppColors.textAccent),
    ColorSwatch("textWarning", "#9A6208", StockAppColors.textWarning),
)

private val semanticBackgroundSwatches = listOf(
    ColorSwatch("bgSuccess", "#E6F3EA", StockAppColors.bgSuccess),
    ColorSwatch("bgDanger", "#FBEAE8", StockAppColors.bgDanger),
    ColorSwatch("bgAccent", "#FDE8F0", StockAppColors.bgAccent),
    ColorSwatch("bgWarning", "#FBF0DC", StockAppColors.bgWarning),
)

private val borderSwatches = listOf(
    ColorSwatch("border", "#E7E1D9", StockAppColors.border),
    ColorSwatch("divider", "#F3EEE7", StockAppColors.divider),
    ColorSwatch("segTrack", "#EAE5DE", StockAppColors.segTrack),
    ColorSwatch("sheetHandle", "#DCD5CC", StockAppColors.sheetHandle),
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
        ShowcaseGroup("Marca (tema Framboesa)") { SwatchGrid(brandSwatches) }
        ShowcaseGroup("Superfícies") { SwatchGrid(surfaceSwatches) }
        ShowcaseGroup("Texto") { SwatchGrid(textSwatches) }
        ShowcaseGroup("Fundos semânticos (badges, alertas)") { SwatchGrid(semanticBackgroundSwatches) }
        ShowcaseGroup("Bordas e traços") { SwatchGrid(borderSwatches) }
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
