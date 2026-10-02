// commonMain: util/DateFormat.kt
package com.danilobarreto.stockapp.designsystem.util

expect fun todayIsoDate(): String

/** 1727740800000 (meia-noite UTC) → "2026-10-01" */
fun Long.utcMillisToIsoDate(): String {
    val z = this.floorDiv(86_400_000L) + 719_468
    val era = z.floorDiv(146_097L)
    val doe = z - era * 146_097
    val yoe = (doe - doe / 1460 + doe / 36_524 - doe / 146_096) / 365
    val doy = doe - (365 * yoe + yoe / 4 - yoe / 100)
    val mp = (5 * doy + 2) / 153
    val d = doy - (153 * mp + 2) / 5 + 1
    val m = if (mp < 10) mp + 3 else mp - 9
    val y = yoe + era * 400 + if (m <= 2) 1 else 0
    return "${y.toString().padStart(4, '0')}-${m.toString().padStart(2, '0')}-${d.toString().padStart(2, '0')}"
}

/** "2026-10-01" → millis da meia-noite UTC (o que o DatePicker espera) */
fun String.isoToUtcMillis(): Long? {
    val parts = split("-").mapNotNull { it.toIntOrNull() }
    if (parts.size != 3) return null
    val (year, m, d) = parts
    val y = (if (m <= 2) year - 1 else year).toLong()
    val era = y.floorDiv(400L)
    val yoe = y - era * 400
    val mp = if (m > 2) m - 3 else m + 9
    val doy = (153 * mp + 2) / 5 + d - 1
    val doe = yoe * 365 + yoe / 4 - yoe / 100 + doy
    return (era * 146_097 + doe - 719_468) * 86_400_000L
}

/** "2026-10-01" → "01/10/2026" */
fun String.isoToBrDate(): String =
    split("-").let { if (it.size == 3) "${it[2]}/${it[1]}/${it[0]}" else this }