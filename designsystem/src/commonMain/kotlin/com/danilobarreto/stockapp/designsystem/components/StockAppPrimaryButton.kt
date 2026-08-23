package com.danilobarreto.stockapp.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppShapes
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

@Composable
fun StockAppPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false
){
    Button(
        onClick = onClick,
        enabled = enabled && !loading,
        shape = StockAppShapes.pillRadius,
        colors = ButtonDefaults.buttonColors(
            containerColor = StockAppColors.textAccent,
            contentColor = StockAppColors.surface2,
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
    ){
        if(loading){
            CircularProgressIndicator(
                modifier = Modifier.height(20.dp),
                color = StockAppColors.surface2,
                strokeWidth = 2.dp
            )
        } else {
            Text(text, style = StockAppTypography.buttonLabel)
        }
    }
}