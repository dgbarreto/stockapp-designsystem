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

// StockAppShapes only declares these two — every value in theme/Shape.kt is represented below.
private val shapeSamples = listOf(
    ShapeSample(
        propertyName = "cardRadius",
        declaration = "RoundedCornerShape(8.dp)",
        description = "8dp de raio — cards, campos de texto, botões",
        shape = StockAppShapes.cardRadius,
    ),
    ShapeSample(
        propertyName = "pillRadius",
        declaration = "RoundedCornerShape(50)",
        description = "50% de raio — formato pílula, usado em badges",
        shape = StockAppShapes.pillRadius,
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
