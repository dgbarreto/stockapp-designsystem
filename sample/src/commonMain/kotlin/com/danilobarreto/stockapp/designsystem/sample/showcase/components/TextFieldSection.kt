package com.danilobarreto.stockapp.designsystem.sample.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.components.StockAppTextField
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseEntry
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

@Composable
fun TextFieldSection(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }
    var isPasswordOn by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Interativo (aceita digitação e alterna isPassword)",
            description = "O switch \"isPassword\" abaixo do campo não faz parte do componente — é um " +
                "controle do showcase para demonstrar o parâmetro isPassword ao vivo.",
            code = """
                StockAppTextField(
                    label = "Senha",
                    value = value,
                    onValueChange = { value = it },
                    placeholder = "Digite sua senha",
                    isPassword = $isPasswordOn,
                )
            """.trimIndent(),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                StockAppTextField(
                    label = "Senha",
                    value = value,
                    onValueChange = { value = it },
                    placeholder = "Digite sua senha",
                    isPassword = isPasswordOn,
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("isPassword", style = StockAppTypography.labelMedium, color = StockAppColors.textSecondary)
                    Switch(
                        checked = isPasswordOn,
                        onCheckedChange = { isPasswordOn = it },
                        modifier = Modifier.padding(start = 8.dp),
                    )
                }
            }
        }

        ShowcaseEntry(
            name = "Estado de erro",
            description = "isError = true, supportingText informado",
            code = """
                StockAppTextField(
                    label = "E-mail",
                    value = "danilo@",
                    onValueChange = { },
                    isError = true,
                    supportingText = "E-mail inválido",
                )
            """.trimIndent(),
        ) {
            StockAppTextField(
                label = "E-mail",
                value = "danilo@",
                onValueChange = { },
                isError = true,
                supportingText = "E-mail inválido",
            )
        }
    }
}
