package com.danilobarreto.stockapp.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppShapes
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

@Composable
fun StockAppCodeInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    length: Int = 6,
) {
    var fieldValue by remember(value) {
        mutableStateOf(TextFieldValue(text = value, selection = TextRange(value.length)))
    }

    BasicTextField(
        value = fieldValue,
        onValueChange = { newValue ->
            val digitsOnly = newValue.text.filter { it.isDigit() }.take(length)
            fieldValue = newValue.copy(text = digitsOnly, selection = TextRange(digitsOnly.length))
            onValueChange(digitsOnly)
        },
        modifier = modifier,
        textStyle = LocalTextStyle.current.copy(color = Color.Transparent),
        cursorBrush = SolidColor(Color.Transparent),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = { innerTextField ->
            Box {
                innerTextField() // invisível — só segura foco/teclado/cola de verdade
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    repeat(length) { index ->
                        val digit = value.getOrNull(index)?.toString() ?: ""
                        val isCurrent = index == value.length
                        Box(
                            modifier = Modifier
                                .size(46.dp)
                                .background(StockAppColors.divider, shape = StockAppShapes.fieldRadius)
                                .border(
                                    width = if (isCurrent) 1.5.dp else 0.dp,
                                    color = if (isCurrent) StockAppColors.primary else Color.Transparent,
                                    shape = StockAppShapes.fieldRadius,
                                ),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = digit,
                                style = StockAppTypography.titleLarge.copy(fontSize = 20.sp),
                                color = StockAppColors.textPrimary,
                            )
                        }
                    }
                }
            }
        },
    )
}