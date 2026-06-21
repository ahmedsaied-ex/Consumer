package com.example.consumer.core.domain.dataStorage.language


import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

actual object LocalAppLocale {
    private val LocalAppLocaleProvider = staticCompositionLocalOf { "ar" }

    actual val current: String
        @Composable get() = LocalAppLocaleProvider.current

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        val effectiveValue = value ?: "ar"
        val configuration = LocalConfiguration.current
        val newLocale = Locale(effectiveValue)

        Locale.setDefault(newLocale)
        configuration.setLocale(newLocale)
        val resources = LocalContext.current.resources
        resources.updateConfiguration(configuration, resources.displayMetrics)

        return LocalAppLocaleProvider.provides(effectiveValue)
    }
}