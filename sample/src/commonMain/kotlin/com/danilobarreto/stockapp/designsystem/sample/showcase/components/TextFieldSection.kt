package com.danilobarreto.stockapp.designsystem.sample.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.components.StockAppTextField
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseEntry

@Composable
fun TextFieldSection(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ShowcaseEntry(
            name = "Interativo (aceita digitação)",
            code = """
                StockAppTextField(
                    label = "Nome",
                    value = name,
                    onValueChange = { name = it },
                    placeholder = "Como você se chama?",
                )
            """.trimIndent(),
        ) {
            StockAppTextField(
                label = "Nome",
                value = name,
                onValueChange = { name = it },
                placeholder = "Como você se chama?",
            )
        }

        ShowcaseEntry(
            name = "Senha (interativo — toque no ícone de olho para revelar)",
            description = "isPassword = true agora renderiza o próprio ícone de olho do componente " +
                "(StockAppIcons.Eye / EyeOff) como trailing icon.",
            code = """
                StockAppTextField(
                    label = "Senha",
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Digite sua senha",
                    isPassword = true,
                )
            """.trimIndent(),
        ) {
            StockAppTextField(
                label = "Senha",
                value = password,
                onValueChange = { password = it },
                placeholder = "Digite sua senha",
                isPassword = true,
            )
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
