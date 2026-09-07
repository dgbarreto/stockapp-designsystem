package com.danilobarreto.stockapp.designsystem.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke as DrawStroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Contorno tracejado — usado hoje na dropzone de importação (tela "Importar extrato").
 * Compose não tem um Modifier.border tracejado nativo; isso desenha o retângulo
 * arredondado com PathEffect.dashPathEffect diretamente no Canvas do drawBehind.
 */
fun Modifier.stockAppDashedBorder(
    color: Color,
    cornerRadius: Dp,
    strokeWidth: Dp = 2.dp,
    dashLength: Dp = 8.dp,
    gapLength: Dp = 6.dp,
): Modifier = composed {
    drawBehind {
        val stroke = DrawStroke(
            width = strokeWidth.toPx(),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength.toPx(), gapLength.toPx()), 0f),
        )
        drawRoundRect(
            color = color,
            size = Size(size.width - stroke.width, size.height - stroke.width),
            topLeft = androidx.compose.ui.geometry.Offset(stroke.width / 2, stroke.width / 2),
            cornerRadius = CornerRadius(cornerRadius.toPx(), cornerRadius.toPx()),
            style = stroke,
        )
    }
}