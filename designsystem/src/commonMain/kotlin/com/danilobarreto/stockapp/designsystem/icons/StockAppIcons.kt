package com.danilobarreto.stockapp.designsystem.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.danilobarreto.stockapp.designsystem.generated.resources.Res
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_arrow_left
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_arrow_up_right
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_bell
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_chart_candle
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_check
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_chevron_right
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_coin
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_eye
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_eye_off
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_home
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_log_out
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_minus
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_plus
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_search
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_target
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_upload
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_user
import com.danilobarreto.stockapp.designsystem.generated.resources.ic_wallet
import org.jetbrains.compose.resources.vectorResource

object StockAppIcons {
    val Eye: ImageVector @Composable get() = vectorResource(Res.drawable.ic_eye)
    val EyeOff: ImageVector @Composable get() = vectorResource(Res.drawable.ic_eye_off)
    val ArrowLeft: ImageVector @Composable get() = vectorResource(Res.drawable.ic_arrow_left)
    val Plus: ImageVector @Composable get() = vectorResource(Res.drawable.ic_plus)
    val Minus: ImageVector @Composable get() = vectorResource(Res.drawable.ic_minus)
    val Upload: ImageVector @Composable get() = vectorResource(Res.drawable.ic_upload)
    val Target: ImageVector @Composable get() = vectorResource(Res.drawable.ic_target)
    val Bell: ImageVector @Composable get() = vectorResource(Res.drawable.ic_bell)
    val ArrowUpRight: ImageVector @Composable get() = vectorResource(Res.drawable.ic_arrow_up_right)
    val Search: ImageVector @Composable get() = vectorResource(Res.drawable.ic_search)
    val Coin: ImageVector @Composable get() = vectorResource(Res.drawable.ic_coin)
    val Home: ImageVector @Composable get() = vectorResource(Res.drawable.ic_home)
    val Wallet: ImageVector @Composable get() = vectorResource(Res.drawable.ic_wallet)
    val ChartCandle: ImageVector @Composable get() = vectorResource(Res.drawable.ic_chart_candle)
    val User: ImageVector @Composable get() = vectorResource(Res.drawable.ic_user)
    val Check: ImageVector @Composable get() = vectorResource(Res.drawable.ic_check)
    val LogOut: ImageVector @Composable get() = vectorResource(Res.drawable.ic_log_out)
    val ChevronRight: ImageVector @Composable get() = vectorResource(Res.drawable.ic_chevron_right)
}