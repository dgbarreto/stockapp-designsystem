package com.danilobarreto.stockapp.designsystem.sample.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppShapes
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

private data class ShapeSample(
    val propertyName: String,
    val declaration: String,
    val description: String,
    val shape: CornerBasedShape,
)

// Every value declared in theme/Shape.kt (StockAppShapes), in source order.
private val shapeSamples = listOf(
    ShapeSample(
        propertyName = "cardRadius",
        declaration = "RoundedCornerShape(20.dp)",
        description = "cartão de lista (padrão)",
        shape = StockAppShapes.cardRadius,
    ),
    ShapeSample(
        propertyName = "cardRadiusLarge",
        declaration = "RoundedCornerShape(24.dp)",
        description = "cartão grande/destaque (ex.: gráfico, distribuição)",
        shape = StockAppShapes.cardRadiusLarge,
    ),
    ShapeSample(
        propertyName = "fieldRadius",
        declaration = "RoundedCornerShape(14.dp)",
        description = "campo de texto",
        shape = StockAppShapes.fieldRadius,
    ),
    ShapeSample(
        propertyName = "avatarRadius",
        declaration = "RoundedCornerShape(13.dp)",
        description = "avatar de ticker",
        shape = StockAppShapes.avatarRadius,
    ),
    ShapeSample(
        propertyName = "pillRadius",
        declaration = "RoundedCornerShape(50)",
        description = "pill/botão",
        shape = StockAppShapes.pillRadius,
    ),
    ShapeSample(
        propertyName = "sheetTopRadius",
        declaration = "RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)",
        description = "topo do bottom sheet",
        shape = StockAppShapes.sheetTopRadius,
    ),
    ShapeSample(
        propertyName = "headerBottomRadius",
        declaration = "RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)",
        description = "header colorido das telas principais",
        shape = StockAppShapes.headerBottomRadius,
    ),
    ShapeSample(
        propertyName = "controlRadius",
        declaration = "RoundedCornerShape(10.dp)",
        description = "botões de controle pequenos (stepper, segmented control)",
        shape = StockAppShapes.controlRadius,
    ),
)

@Composable
fun ShapesScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        shapeSamples.forEach { sample ->
            ShowcaseEntry(
                name = "StockAppShapes.${sample.propertyName}",
                description = sample.description,
                code = "Modifier.background(\n    color = StockAppColors.bgAccent,\n    shape = StockAppShapes.${sample.propertyName},\n)",
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(width = 120.dp, height = 56.dp)
                            .background(StockAppColors.bgAccent, shape = sample.shape)
                    )
                    Column(modifier = Modifier.padding(start = 16.dp)) {
                        Text(sample.declaration, style = StockAppTypography.bodyMedium, color = StockAppColors.textPrimary)
                    }
                }
            }
        }
    }
}
