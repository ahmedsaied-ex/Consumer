package com.example.consumer.core.presentation.utils

import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime

fun String.toDisplayDate(): String {
    return try {
        val parts = this.substringBefore("T").split("-")
        val year = parts[0]
        val month = parts[1].trimStart('0')
        val day = parts[2].trimStart('0')
        "$day/$month/$year"
    } catch (e: Exception) {
        this // return original if parsing fails
    }
}