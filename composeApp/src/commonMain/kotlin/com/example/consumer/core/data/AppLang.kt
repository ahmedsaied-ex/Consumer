package com.example.consumer.core.data

enum class AppLang(val code: String) {
    ENGLISH("en"),
    ARABIC("ar");

    companion object {
        fun fromCode(code: String?): AppLang {
            return entries.find { it.code == code } ?: ARABIC
        }
    }
}

fun String?.toAppLang(): AppLang = AppLang.fromCode(this)
