package com.example.consumer.features.profile.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.consumer.core.data.AppLang


@Composable
fun LanguageSelectorContent(
    selectedLanguage: AppLang,
    onLanguageSelected: (AppLang) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LanguageItemRow(
            title = "English",
            selected = selectedLanguage == AppLang.ENGLISH,
            onClick = { onLanguageSelected(AppLang.ENGLISH) }
        )
        LanguageItemRow(
            title = "العربية",
            selected = selectedLanguage == AppLang.ARABIC,
            onClick = { onLanguageSelected(AppLang.ARABIC) }
        )
    }
}