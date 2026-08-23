package com.danilobarreto.stockapp.designsystem.sample.showcase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

/**
 * `StockAppIcons` does not exist anywhere in the designsystem module today — there is no
 * `icons/` package under `theme/` or elsewhere in `commonMain`. This screen exists so the gap
 * is visible in the showcase itself rather than silently skipped, per the showcase spec's
 * "say so explicitly rather than omitting it without comment" rule. Once an icon set is added
 * to the module, this screen should be replaced with a real grid over its entries.
 */
@Composable
fun IconsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            "StockAppIcons não existe neste módulo",
            style = StockAppTypography.titleMedium,
            color = StockAppColors.textPrimary,
        )
        Text(
            "O showcase foi escrito a partir do conteúdo real de designsystem/src/commonMain — " +
                "não existe icons/StockAppIcons.kt (nem qualquer outro arquivo de ícones) no módulo " +
                "hoje. Esta seção fica como placeholder, de propósito, em vez de inventar ícones que " +
                "não existem no código.",
            style = StockAppTypography.bodyMedium,
            color = StockAppColors.textSecondary,
        )
    }
}
