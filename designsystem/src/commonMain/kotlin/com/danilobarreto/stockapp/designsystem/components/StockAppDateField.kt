package com.danilobarreto.stockapp.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.danilobarreto.stockapp.designsystem.icons.StockAppIcons
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.util.isoToBrDate
import com.danilobarreto.stockapp.designsystem.util.isoToUtcMillis
import com.danilobarreto.stockapp.designsystem.util.todayIsoDate
import com.danilobarreto.stockapp.designsystem.util.utcMillisToIsoDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockAppDateField(
    label: String,
    isoDate: String,                       // "yyyy-MM-dd"
    onDateSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    allowFuture: Boolean = false,
) {
    var showPicker by remember { mutableStateOf(false) }

    Box(modifier) {
        StockAppTextField(
            label = label,
            value = isoDate.isoToBrDate(),
            onValueChange = {},
            leadingIcon = StockAppIcons.Calendar,   // ver nota abaixo
        )
        // Camada transparente por cima: captura o toque antes do TextField,
        // então o teclado nunca abre — o campo vira só um "botão" que abre o picker.
        Box(
            Modifier
                .matchParentSize()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                ) { showPicker = true }
        )
    }

    if (showPicker) {
        val todayMillis = remember { todayIsoDate().isoToUtcMillis() ?: Long.MAX_VALUE }
        val state = rememberDatePickerState(
            initialSelectedDateMillis = isoDate.isoToUtcMillis(),
            selectableDates = object : SelectableDates {
                override fun isSelectableDate(utcTimeMillis: Long) =
                    allowFuture || utcTimeMillis <= todayMillis
            },
        )
        DatePickerDialog(
            onDismissRequest = { showPicker = false },
            confirmButton = {
                TextButton(onClick = {
                    state.selectedDateMillis?.let { onDateSelected(it.utcMillisToIsoDate()) }
                    showPicker = false
                }) { Text("OK", color = StockAppColors.primary) }
            },
            dismissButton = {
                TextButton(onClick = { showPicker = false }) {
                    Text("Cancelar", color = StockAppColors.textSecondary)
                }
            },
        ) {
            DatePicker(state = state)
        }
    }
}