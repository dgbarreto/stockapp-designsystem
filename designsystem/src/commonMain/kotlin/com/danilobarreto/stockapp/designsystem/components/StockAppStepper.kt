package com.danilobarreto.stockapp.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danilobarreto.stockapp.designsystem.icons.StockAppIcons
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppShapes
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun StockAppStepper(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    min: Int = 1,
    max: Int = Int.MAX_VALUE,
    step: Int = 1,
) {
    var text by remember { mutableStateOf(TextFieldValue(value.toString())) }
    val interactionSource = remember { MutableInteractionSource() }
    val focused by interactionSource.collectIsFocusedAsState()
    var hadFocus by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    // Valor mudou por fora (botões −/+) e o campo não está em edição → o texto acompanha.
    LaunchedEffect(value) {
        if (!focused) text = TextFieldValue(value.toString())
    }

    LaunchedEffect(focused) {
        if (focused) {
            hadFocus = true
            // Seleciona tudo ao entrar: o primeiro dígito digitado substitui o número inteiro.
            text = text.copy(selection = TextRange(0, text.text.length))
        } else if (hadFocus) {
            // Saiu do campo: normaliza (vazio/0 → min, acima do max → max).
            val committed = (text.text.toIntOrNull() ?: min).coerceIn(min, max)
            onValueChange(committed)
            text = TextFieldValue(committed.toString())
        }
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        StepperButton(
            icon = StockAppIcons.Minus,
            contentDescription = "Diminuir",
            enabled = value > min,
            onClick = {
                focusManager.clearFocus()
                onValueChange((value - step).coerceAtLeast(min))
            },
        )
        BasicTextField(
            value = text,
            onValueChange = { new ->
                val digits = new.text.filter(Char::isDigit).take(9)
                text = TextFieldValue(digits, selection = TextRange(new.selection.end.coerceAtMost(digits.length)))
                digits.toIntOrNull()?.let { onValueChange(it.coerceAtMost(max)) }
            },
            singleLine = true,
            textStyle = StockAppTypography.headerTitle.copy(
                fontSize = 22.sp,
                color = StockAppColors.textPrimary,
                textAlign = TextAlign.Center,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            interactionSource = interactionSource,
            cursorBrush = SolidColor(StockAppColors.primary),
            modifier = Modifier.weight(1f),
        )
        StepperButton(
            icon = StockAppIcons.Plus,
            contentDescription = "Aumentar",
            enabled = value < max,
            onClick = {
                focusManager.clearFocus()
                onValueChange((value + step).coerceAtMost(max))
            },
        )
    }
}

@Composable
private fun StepperButton(
    icon: ImageVector,
    contentDescription: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(34.dp)
            .background(StockAppColors.primaryTint, shape = StockAppShapes.controlRadius)
            .clickable(enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = StockAppColors.primaryDeep,
            modifier = Modifier.size(18.dp),
        )
    }
}