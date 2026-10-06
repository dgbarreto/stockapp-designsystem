package com.danilobarreto.stockapp.designsystem.theme

import androidx.compose.ui.unit.dp

object StockAppSpacing {
    // Escala base — usar quando não houver um semântico que descreva o caso
    val xxs = 2.dp
    val xs = 4.dp
    val sm = 8.dp
    val md = 12.dp
    val lg = 16.dp
    val xl = 20.dp
    val xxl = 24.dp
    val xxxl = 32.dp

    // Semânticos — o que as telas devem usar
    val screenHorizontal = xl     // margem lateral do conteúdo E do header colorido (alinhados)
    val headerTop = lg            // abaixo da status bar, dentro do header colorido
    val headerBottom = 26.dp      // fim do header colorido
    val sectionGap = xxl          // entre seções da tela (Evolução → Seus ativos → Alertas)
    val sectionTitleGap = 10.dp   // título de seção → conteúdo
    val cardPadding = lg          // padding interno de cartão
    val itemGap = 10.dp           // itens lado a lado (atalhos, cartões do header)
}