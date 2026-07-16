package com.danilobarreto.stockapp.designsystem.util

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.round

fun Double.toDecimalString(decimals: Int = 2): String{
    val multiplier = 10.0.pow(decimals)
    val rounded = round(this * multiplier) / multiplier
    val absRounded = abs(rounded)

    val integerPart = absRounded.toLong().toString()
    val decimalPart = if(decimals > 0){
        val fractional = absRounded - absRounded.toLong()
        round(fractional * multiplier).toLong().toString().padStart(decimals, '0')
    } else null

    val sign = if(rounded < 0) "-" else ""
    return if(decimalPart != null) "$sign$integerPart.$decimalPart" else "$sign$integerPart"
}