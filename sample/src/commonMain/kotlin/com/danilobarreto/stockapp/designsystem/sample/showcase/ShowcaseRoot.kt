package com.danilobarreto.stockapp.designsystem.sample.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

enum class ShowcaseSection(val label: String) {
    Colors("Cores"),
    Shapes("Formas"),
    Typography("Tipografia"),
    Icons("Ícones"),
    Components("Componentes"),
}

/**
 * Root of the design system showcase: a title, a top-level tab per token/component category,
 * and the selected category's content below. Everything renders through [StockAppTheme] —
 * this composable assumes it is already inside one (see SampleApp).
 */
@Composable
fun ShowcaseRoot(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(ShowcaseSection.Colors) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(StockAppColors.surface1)
            .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Top))
    ) {
        Text(
            text = "StockApp Design System",
            style = StockAppTypography.titleLarge,
            color = StockAppColors.textPrimary,
            modifier = Modifier.padding(16.dp)
        )

        SecondaryScrollableTabRow(
            selectedTabIndex = selected.ordinal,
            containerColor = StockAppColors.surface2,
            contentColor = StockAppColors.textAccent,
            edgePadding = 16.dp,
        ) {
            ShowcaseSection.entries.forEach { section ->
                Tab(
                    selected = selected == section,
                    onClick = { selected = section },
                    text = { Text(section.label, style = StockAppTypography.labelMedium) },
                )
            }
        }

        Box(modifier = Modifier.fillMaxWidth().fillMaxSize()) {
            when (selected) {
                ShowcaseSection.Colors -> ColorsScreen()
                ShowcaseSection.Shapes -> ShapesScreen()
                ShowcaseSection.Typography -> TypographyScreen()
                ShowcaseSection.Icons -> IconsScreen()
                ShowcaseSection.Components -> ComponentsScreen()
            }
        }
    }
}
