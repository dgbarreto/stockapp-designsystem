package com.danilobarreto.stockapp.designsystem.theme

import androidx.compose.ui.graphics.Color

object StockAppColors {
    // Cor de marca (tema "Framboesa")
    val primary = Color(0xFFC6155C)       // header das telas principais, botões primários, FAB, tab bar ativa
    val primaryDeep = Color(0xFF6E0A32)   // texto/ícones sobre primaryTint, links secundários
    val primaryTint = Color(0xFFFDE8F0)   // fundo de avatar de ticker, chips, cartão de total da ordem
    val onPrimary = Color(0xFFFFFFFF)     // texto/ícones sobre a cor primary

    // Superfícies
    val bg = Color(0xFFF7F2F4)            // fundo da tela (era surface1)
    val surface1 = Color(0xFFF7F2F4)      // fundo da tela (era bg no rascunho anterior)
    val surface2 = Color(0xFFFFFFFF)      // cards, rows, tab bar1

    // Texto
    val textPrimary = Color(0xFF1A1014)   // "ink"
    val textSecondary = Color(0xFF6B5860) // "ink-2"
    val textMuted = Color(0xFFA79E96)     // "ink-4" — placeholder, ícone/label inativo
    val textSuccess = Color(0xFF1F7A47)   // "positivo"
    val textDanger = Color(0xFFB3251F)    // "negativo"
    val textAccent = Color(0xFFC6155C)    // mesmo valor de `primary` — mantido por compatibilidade com telas existentes
    val textWarning = Color(0xFF9A6208)   // "atenção"

    // Fundos semânticos (badges, alertas)
    val bgSuccess = Color(0xFFE6F3EA)
    val bgDanger = Color(0xFFFBEAE8)
    val bgAccent = Color(0xFFFDE8F0)      // mesmo valor de `primaryTint`
    val bgWarning = Color(0xFFFBF0DC)

    val border = Color(0xFFE7E1D9)
    val divider = Color(0xFFF3EEE7)       // divisória entre linhas de lista dentro de card
    val segTrack = Color(0xFFEAE5DE)      // trilha do controle segmentado
    val sheetHandle = Color(0xFFDCD5CC)   // alça (grabber) do topo do bottom sheet
}