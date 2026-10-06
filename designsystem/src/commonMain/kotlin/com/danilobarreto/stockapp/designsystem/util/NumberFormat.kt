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

/** 62284.02 → "62.284,02" — exibição pt-BR (milhar com ponto, decimal com vírgula). */
fun Double.toBrNumber(decimals: Int = 2): String {
    val raw = toDecimalString(decimals)              // reaproveita o arredondamento
    val negative = raw.startsWith("-")
    val unsigned = raw.removePrefix("-")
    val intPart = unsigned.substringBefore('.')
    val decPart = unsigned.substringAfter('.', "")

    val grouped = intPart.reversed().chunked(3).joinToString(".").reversed()
    val sign = if (negative) "-" else ""
    return if (decPart.isEmpty()) "$sign$grouped" else "$sign$grouped,$decPart"
}

/** 62284.02 → "R$ 62.284,02"; -150.5 → "-R$ 150,50" */
fun Double.toBrl(): String =
    if (this < 0) "-R$ ${(-this).toBrNumber(2)}" else "R$ ${toBrNumber(2)}"

/** -3.8412 → "-3,84%"; com signed = true, positivo ganha "+" ("+17,90%") */
fun Double.toBrPercent(decimals: Int = 2, signed: Boolean = false): String {
    val prefix = if (signed && this > 0) "+" else ""
    return "$prefix${toBrNumber(decimals)}%"
}