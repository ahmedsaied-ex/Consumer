package com.example.consumer.core.domain.dataStorage.language

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf
import platform.Foundation.NSUserDefaults

actual object LocalAppLocale {
    private const val LANG_KEY = "AppleLanguages"
    private val LocalAppLocaleProvider = staticCompositionLocalOf { "ar" }

    actual val current: String
        @Composable get() = LocalAppLocaleProvider.current

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        val new = value ?: "ar"
        NSUserDefaults.standardUserDefaults.setObject(listOf(new), LANG_KEY)
        return LocalAppLocaleProvider.provides(new)
    }
}
