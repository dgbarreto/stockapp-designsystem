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
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.BottomSheetHandleSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.CardSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.ChipSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.ErrorBannerSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.FabSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.KeyValueRowSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.PrimaryButtonSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.SegmentedControlSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.StepperSection
import com.danilobarreto.stockapp.designsystem.sample.showcase.components.TextFieldSection
import com.danilobarreto.stockapp.designsystem.theme.StockAppColors
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

// One entry per public composable under designsystem/src/commonMain/.../components/ — nothing
// in that package is skipped. Chip, Fab, SegmentedControl, Stepper and BottomSheetHandle were
// added by the Framboesa rebrand (#20).
enum class ComponentKind(val label: String) {
    Avatar("Avatar"),
    Badge("Badge"),
    BottomSheetHandle("BottomSheetHandle"),
    Card("Card"),
    Chip("Chip"),
    ErrorBanner("ErrorBanner"),
    Fab("Fab"),
    KeyValueRow("KeyValueRow"),
    PrimaryButton("PrimaryButton"),
    SegmentedControl("SegmentedControl"),
    Stepper("Stepper"),
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
                ComponentKind.BottomSheetHandle -> BottomSheetHandleSection()
                ComponentKind.Card -> CardSection()
                ComponentKind.Chip -> ChipSection()
                ComponentKind.ErrorBanner -> ErrorBannerSection()
                ComponentKind.Fab -> FabSection()
                ComponentKind.KeyValueRow -> KeyValueRowSection()
                ComponentKind.PrimaryButton -> PrimaryButtonSection()
                ComponentKind.SegmentedControl -> SegmentedControlSection()
                ComponentKind.Stepper -> StepperSection()
                ComponentKind.TextField -> TextFieldSection()
            }
        }
    }
}
