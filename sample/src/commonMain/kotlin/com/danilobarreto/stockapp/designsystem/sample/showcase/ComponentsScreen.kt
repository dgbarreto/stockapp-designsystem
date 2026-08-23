package com.danilobarreto.stockapp.designsystem.sample.showcase

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.AvatarSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.BadgeSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.CardSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.ErrorBannerSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.KeyValueRowSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.PrimaryButtonSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.TextFieldSection
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

// One entry per public composable under designsystem/src/commonMain/.../components/ — nothing
// in that package is skipped.
enum class ComponentKind(val label: String) {
    Avatar("Avatar"),
    Badge("Badge"),
    Card("Card"),
    ErrorBanner("ErrorBanner"),
    KeyValueRow("KeyValueRow"),
    PrimaryButton("PrimaryButton"),
    TextField("TextField"),
}

@Composable
fun ComponentsScreen(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(ComponentKind.Avatar) }

    Column(modifier = modifier.fillMaxSize()) {
        SecondaryScrollableTabRow(
            selectedTabIndex = selected.ordinal,
            containerColor = StockAppColors.surface1,
            contentColor = StockAppColors.textAccent,
            edgePadding = 16.dp,
        ) {
            ComponentKind.entries.forEach { kind ->
                Tab(
                    selected = selected == kind,
                    onClick = { selected = kind },
                    text = { Text(kind.label, style = StockAppTypography.labelMedium) },
                )
            }
        }

        Box(modifier = Modifier.fillMaxWidth().fillMaxSize()) {
            when (selected) {
                ComponentKind.Avatar -> AvatarSection()
                ComponentKind.Badge -> BadgeSection()
                ComponentKind.Card -> CardSection()
                ComponentKind.ErrorBanner -> ErrorBannerSection()
                ComponentKind.KeyValueRow -> KeyValueRowSection()
                ComponentKind.PrimaryButton -> PrimaryButtonSection()
                ComponentKind.TextField -> TextFieldSection()
            }
        }
    }
}
