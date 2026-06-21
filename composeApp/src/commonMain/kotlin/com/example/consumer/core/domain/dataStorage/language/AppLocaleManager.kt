package com.example.consumer.core.domain.dataStorage.language

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.example.consumer.core.data.AppLang
import com.example.consumer.core.data.dataStore.language.LanguageDataStore
import com.example.consumer.core.data.toAppLang

/**
 * Expected object to handle platform-specific locale changes.
 */
expect object LocalAppLocale {
    val current: String @Composable get
    @Composable infix fun provides(value: String?): ProvidedValue<*>
}

@Composable
fun AppLocaleProvider(
    languageDataStore: LanguageDataStore,
    content: @Composable (AppLang) -> Unit
) {
    val langCode by languageDataStore.selectedLanguageFlow
        .collectAsState(initial = AppLang.ARABIC.code)

    val effectiveLangCode = langCode ?: AppLang.ARABIC.code
    val appLang = remember(effectiveLangCode) { effectiveLangCode.toAppLang() }
    val layoutDirection = if (appLang == AppLang.ARABIC) LayoutDirection.Rtl else LayoutDirection.Ltr

    CompositionLocalProvider(
        LocalAppLocale provides effectiveLangCode,
        LocalLayoutDirection provides layoutDirection
    ) {
        content(appLang)
    }
}
