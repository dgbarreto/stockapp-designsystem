package com.danilobarreto.stockapp.designsystem.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.icons.StockAppIcons
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppShapes
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

@Composable
fun StockAppTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    isError: Boolean = false,
    supportingText: String? = null,
    leadingIcon: ImageVector? = null,
){
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth()){
        Text(
            text = label,
            style = StockAppTypography.labelMedium,
            color = StockAppColors.textSecondary,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = placeholder?.let { { Text(it) } },
            singleLine = true,
            supportingText = supportingText?.let { { Text(it) } },
            textStyle = StockAppTypography.bodyMedium,
            visualTransformation = when {
                isPassword && !passwordVisible -> PasswordVisualTransformation()
                else -> VisualTransformation.None
            },
            leadingIcon = leadingIcon?.let {
                { Icon(imageVector = it, contentDescription = null, tint = StockAppColors.primary) }
            },
            trailingIcon = if (isPassword) {
                {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) StockAppIcons.EyeOff else StockAppIcons.Eye,
                            contentDescription = if (passwordVisible) "Ocultar senha" else "Mostrar senha",
                            tint = StockAppColors.textMuted,
                        )
                    }
                }
            } else null,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            isError = isError,
            shape = StockAppShapes.fieldRadius,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = StockAppColors.textAccent,
                unfocusedBorderColor = StockAppColors.border,
                unfocusedContainerColor = StockAppColors.surface2,
                focusedContainerColor = StockAppColors.surface2,
            )
        )
    }
}