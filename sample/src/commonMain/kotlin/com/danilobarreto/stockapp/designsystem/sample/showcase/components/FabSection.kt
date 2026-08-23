package com.danilobarreto.stockapp.designsystem.sample.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.components.StockAppFab
import com.danilobarreto.stockapp.designsystem.icons.StockAppIcons
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseEntry
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

@Composable
fun FabSection(modifier: Modifier = Modifier) {
    var tapCount by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Padrão (icon = StockAppIcons.Plus)",
            description = "interativo — toques: $tapCount",
            code = """
                StockAppFab(
                    onClick = { tapCount++ },
                    contentDescription = "Adicionar",
                )
            """.trimIndent(),
        ) {
            Column {
                StockAppFab(
                    onClick = { tapCount++ },
                    contentDescription = "Adicionar",
                    modifier = Modifier.padding(bottom = 4.dp),
                )
                Text("toques: $tapCount", style = StockAppTypography.labelSmall, color = StockAppColors.textSecondary)
            }
        }

        ShowcaseEntry(
            name = "Ícone customizado",
            description = "icon = StockAppIcons.Search",
            code = """
                StockAppFab(
                    onClick = { },
                    icon = StockAppIcons.Search,
                    contentDescription = "Buscar",
                )
            """.trimIndent(),
        ) {
            StockAppFab(
                onClick = { },
                icon = StockAppIcons.Search,
                contentDescription = "Buscar",
            )
        }
    }
}
