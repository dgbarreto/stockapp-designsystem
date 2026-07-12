package com.danilobarreto.stockapp.designsystem

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform