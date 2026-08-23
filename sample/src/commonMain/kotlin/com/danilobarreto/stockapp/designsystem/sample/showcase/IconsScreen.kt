package com.danilobarreto.stockapp.designsystem.sample.showcase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.icons.StockAppIcons
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

private data class IconSample(val propertyName: String, val icon: ImageVector)

@Composable
fun IconsScreen(modifier: Modifier = Modifier) {
    // Every value declared in icons/StockAppIcons.kt, in source order.
    val iconSamples = listOf(
        IconSample("Eye", StockAppIcons.Eye),
        IconSample("EyeOff", StockAppIcons.EyeOff),
        IconSample("ArrowLeft", StockAppIcons.ArrowLeft),
        IconSample("Plus", StockAppIcons.Plus),
        IconSample("Minus", StockAppIcons.Minus),
        IconSample("Upload", StockAppIcons.Upload),
        IconSample("Target", StockAppIcons.Target),
        IconSample("Bell", StockAppIcons.Bell),
        IconSample("ArrowUpRight", StockAppIcons.ArrowUpRight),
        IconSample("Search", StockAppIcons.Search),
        IconSample("Coin", StockAppIcons.Coin),
        IconSample("Home", StockAppIcons.Home),
        IconSample("Wallet", StockAppIcons.Wallet),
        IconSample("ChartCandle", StockAppIcons.ChartCandle),
        IconSample("User", StockAppIcons.User),
        IconSample("Check", StockAppIcons.Check),
        IconSample("LogOut", StockAppIcons.LogOut),
        IconSample("ChevronRight", StockAppIcons.ChevronRight),
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        CodeSnippetCard(
            code = "Icon(\n    imageVector = StockAppIcons.Eye,\n    contentDescription = \"Eye\",\n    tint = StockAppColors.textPrimary,\n)"
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            iconSamples.forEach { sample ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(84.dp),
                ) {
                    Icon(
                        imageVector = sample.icon,
                        contentDescription = sample.propertyName,
                        tint = StockAppColors.textPrimary,
                        modifier = Modifier.size(28.dp),
                    )
                    Text(
                        text = sample.propertyName,
                        style = StockAppTypography.labelSmall,
                        color = StockAppColors.textSecondary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 6.dp),
                    )
                }
            }
        }
    }
}
