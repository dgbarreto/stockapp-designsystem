package com.danilobarreto.stockapp.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

object StockAppShapes {
    val cardRadius = RoundedCornerShape(20.dp)        // cartão de lista (padrão) — era 8.dp
    val cardRadiusLarge = RoundedCornerShape(24.dp)   // cartão grande/destaque (ex.: gráfico, distribuição)
    val fieldRadius = RoundedCornerShape(14.dp)       // campo de texto
    val avatarRadius = RoundedCornerShape(13.dp)      // avatar de ticker
    val pillRadius = RoundedCornerShape(50)           // pill/botão — sem mudança
    val sheetTopRadius = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)       // topo do bottom sheet
    val headerBottomRadius = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp) // header colorido das telas principais
    val controlRadius = RoundedCornerShape(10.dp)   // botões de controle pequenos (stepper, segmented control)
}