package com.danilobarreto.stockapp.designsystem.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object StockAppTypography {
    val titleLarge = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium)  // ex.: valor do patrimônio
    val titleMedium = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium) // títulos de seção
    val bodyMedium = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Medium)  // nome/valor do ativo
    val labelMedium = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal) // labels, badges
    val labelSmall = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Normal)  // metadados (qtd., PM)
}