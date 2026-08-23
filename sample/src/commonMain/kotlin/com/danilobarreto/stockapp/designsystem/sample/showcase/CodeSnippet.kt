package com.danilobarreto.stockapp.designsystem.sample.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppShapes
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

/**
 * Read-only, monospaced rendering of the exact Kotlin call used to produce the preview above it.
 */
@Composable
fun CodeSnippetCard(code: String, modifier: Modifier = Modifier) {
    Text(
        text = code,
        style = StockAppTypography.labelSmall.copy(fontFamily = FontFamily.Monospace),
        color = StockAppColors.textSecondary,
        modifier = modifier
            .fillMaxWidth()
            .background(StockAppColors.segTrack, shape = StockAppShapes.cardRadius)
            .border(1.dp, StockAppColors.border, shape = StockAppShapes.cardRadius)
            .padding(12.dp)
    )
}

/**
 * One documented example: a name, a live preview, and the code snippet that produced it.
 */
@Composable
fun ShowcaseEntry(
    name: String,
    code: String,
    modifier: Modifier = Modifier,
    description: String? = null,
    preview: @Composable () -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(name, style = StockAppTypography.titleMedium, color = StockAppColors.textPrimary)
        if (description != null) {
            Text(description, style = StockAppTypography.labelMedium, color = StockAppColors.textMuted)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(StockAppColors.surface2, shape = StockAppShapes.cardRadius)
                .border(1.dp, StockAppColors.border, shape = StockAppShapes.cardRadius)
                .padding(16.dp)
        ) {
            preview()
        }
        CodeSnippetCard(code)
    }
}

/** A titled group of [ShowcaseEntry]s / swatches within a screen. */
@Composable
fun ShowcaseGroup(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(title, style = StockAppTypography.titleLarge, color = StockAppColors.textPrimary)
        content()
    }
}
