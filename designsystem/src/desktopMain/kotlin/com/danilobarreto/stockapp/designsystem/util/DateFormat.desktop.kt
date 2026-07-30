package com.danilobarreto.stockapp.designsystem.util

import java.time.LocalDate

actual fun todayIsoDate(): String = LocalDate.now().toString()