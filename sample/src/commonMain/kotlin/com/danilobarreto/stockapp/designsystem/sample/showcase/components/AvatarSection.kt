package com.danilobarreto.stockapp.designsystem.sample.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.components.StockAppAvatar
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseEntry
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors

@Composable
fun AvatarSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Fallback (sem imagem)",
            description = "imageUrl = null — mostra o texto de fallback sobre a cor de fundo informada",
            code = """
                StockAppAvatar(
                    imageUrl = null,
                    fallbackText = "DB",
                    fallbackBackgroundColor = StockAppColors.bgAccent,
                    fallbackTextColor = StockAppColors.textAccent,
                )
            """.trimIndent(),
        ) {
            StockAppAvatar(
                imageUrl = null,
                fallbackText = "DB",
                fallbackBackgroundColor = StockAppColors.bgAccent,
                fallbackTextColor = StockAppColors.textAccent,
            )
        }

        ShowcaseEntry(
            name = "Tamanho customizado",
            description = "size = 48.dp",
            code = """
                StockAppAvatar(
                    imageUrl = null,
                    fallbackText = "MG",
                    fallbackBackgroundColor = StockAppColors.bgSuccess,
                    fallbackTextColor = StockAppColors.textSuccess,
                    size = 48.dp,
                )
            """.trimIndent(),
        ) {
            StockAppAvatar(
                imageUrl = null,
                fallbackText = "MG",
                fallbackBackgroundColor = StockAppColors.bgSuccess,
                fallbackTextColor = StockAppColors.textSuccess,
                size = 48.dp,
            )
        }

        ShowcaseEntry(
            name = "Com imageUrl (carregamento de rede)",
            description = "Usa Coil por baixo; se a imagem falhar ao carregar, cai para o fallback automaticamente — requer rede.",
            code = """
                StockAppAvatar(
                    imageUrl = "https://i.pravatar.cc/128?img=12",
                    fallbackText = "AB",
                    fallbackBackgroundColor = StockAppColors.bgWarning,
                    fallbackTextColor = StockAppColors.textWarning,
                    size = 48.dp,
                )
            """.trimIndent(),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                StockAppAvatar(
                    imageUrl = "https://i.pravatar.cc/128?img=12",
                    fallbackText = "AB",
                    fallbackBackgroundColor = StockAppColors.bgWarning,
                    fallbackTextColor = StockAppColors.textWarning,
                    size = 48.dp,
                )
            }
        }
    }
}
