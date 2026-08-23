package com.danilobarreto.stockapp.designsystem.sample

import androidx.compose.runtime.Composable
import com.danilobarreto.stockapp.designsystem.sample.showcase.ShowcaseRoot
import com.danilobarreto.stockapp.designsystem.theme.StockAppTheme

/**
 * Entry point wired from both :sample (desktop) and :sample-android. Renders the full
 * designsystem showcase — every token and every component in the module, each with a live
 * preview and the exact code snippet that produced it — through [StockAppTheme].
 */
@Composable
fun SampleApp() {
    StockAppTheme {
        ShowcaseRoot()
    }
}