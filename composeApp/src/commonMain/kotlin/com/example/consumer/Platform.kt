package com.example.consumer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform