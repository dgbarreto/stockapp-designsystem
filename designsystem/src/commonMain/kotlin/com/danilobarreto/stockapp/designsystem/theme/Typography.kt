package com.danilobarreto.stockapp.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.danilobarreto.stockapp.designsystem.generated.resources.Res
import com.danilobarreto.stockapp.designsystem.generated.resources.bricolage_bold
import com.danilobarreto.stockapp.designsystem.generated.resources.bricolage_extrabold
import com.danilobarreto.stockapp.designsystem.generated.resources.outfit_bold
import com.danilobarreto.stockapp.designsystem.generated.resources.outfit_light
import com.danilobarreto.stockapp.designsystem.generated.resources.outfit_medium
import com.danilobarreto.stockapp.designsystem.generated.resources.outfit_regular
import com.danilobarreto.stockapp.designsystem.generated.resources.outfit_semibold
import org.jetbrains.compose.resources.Font

/** Família de display — números e títulos grandes (Bricolage Grotesque 700/800). */
@Composable
private fun displayFontFamily(): FontFamily = FontFamily(
    Font(Res.font.bricolage_bold, weight = FontWeight.Bold),
    Font(Res.font.bricolage_extrabold, weight = FontWeight.ExtraBold),
)

/** Família de interface/corpo (Outfit 300–700). */
@Composable
private fun bodyFontFamily(): FontFamily = FontFamily(
    Font(Res.font.outfit_light, weight = FontWeight.Light),
    Font(Res.font.outfit_regular, weight = FontWeight.Normal),
    Font(Res.font.outfit_medium, weight = FontWeight.Medium),
    Font(Res.font.outfit_semibold, weight = FontWeight.SemiBold),
    Font(Res.font.outfit_bold, weight = FontWeight.Bold),
)

object StockAppTypography {
    // --- Tokens existentes: nomes preservados (usados em ~50 lugares nos outros repos),
    // só o tamanho/peso/fonte foi recalibrado pro novo padrão visual.
    val titleLarge: TextStyle @Composable get() = // era 24sp — títulos de tela
        TextStyle(fontFamily = displayFontFamily(), fontSize = 30.sp, fontWeight = FontWeight.Bold)
    val titleMedium: TextStyle @Composable get() = // era 15sp — títulos de seção / nome do ativo
        TextStyle(fontFamily = bodyFontFamily(), fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
    val bodyMedium: TextStyle @Composable get() = // era 13sp — item de lista, corpo
        TextStyle(fontFamily = bodyFontFamily(), fontSize = 14.sp, fontWeight = FontWeight.Medium)
    val labelMedium: TextStyle @Composable get() = // era 12sp — labels, badges, chips
        TextStyle(fontFamily = bodyFontFamily(), fontSize = 12.sp, fontWeight = FontWeight.Medium)
    val labelSmall: TextStyle @Composable get() = // era 11sp — metadados (qtd., PM)
        TextStyle(fontFamily = bodyFontFamily(), fontSize = 11.sp, fontWeight = FontWeight.Normal)

    // --- Tokens novos, sem uso ainda — pras telas novas (home, header colorido, valores grandes).
    val displayXLarge: TextStyle @Composable get() = // patrimônio total (home)
        TextStyle(fontFamily = displayFontFamily(), fontSize = 42.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.86).sp)
    val displayLarge: TextStyle @Composable get() = // preço do ativo
        TextStyle(fontFamily = displayFontFamily(), fontSize = 40.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.82).sp)
    val displayMedium: TextStyle @Composable get() = // total da carteira
        TextStyle(fontFamily = displayFontFamily(), fontSize = 36.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.72).sp)
    val headerTitle: TextStyle @Composable get() = // título dentro do header colorido
        TextStyle(fontFamily = displayFontFamily(), fontSize = 26.sp, fontWeight = FontWeight.Bold)
    val buttonLabel: TextStyle @Composable get() = // texto de botão primário
        TextStyle(fontFamily = bodyFontFamily(), fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
    val bodySmall: TextStyle @Composable get() = // texto secundário
        TextStyle(fontFamily = bodyFontFamily(), fontSize = 13.sp, fontWeight = FontWeight.Normal)
    val labelTable: TextStyle @Composable get() = // label de tabela dentro de card
        TextStyle(fontFamily = bodyFontFamily(), fontSize = 10.5.sp, fontWeight = FontWeight.Medium)
}