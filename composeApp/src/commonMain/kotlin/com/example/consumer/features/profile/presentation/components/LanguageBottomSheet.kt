package com.example.consumer.features.profile.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.consumer.core.data.AppLang
import com.example.consumer.core.presentation.components.bottomSheets.CostumeBottomSheet
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.theme.ConsumerTheme

@Composable
fun LanguageBottomSheet(
    modifier: Modifier = Modifier,
    selectedLanguage: AppLang,
    onDismiss: () -> Unit,
    onLanguageSelected: (AppLang) -> Unit
) {
    CostumeBottomSheet(
        onDismiss = onDismiss,
        modifier = modifier
    ){
        LanguageSelectorContent(
            selectedLanguage = selectedLanguage,
            onLanguageSelected = onLanguageSelected
        )
    }
}



@Composable
@Preview(showBackground = true, locale = "ar")
fun LanguageBottomSheetPreview() {
    ConsumerTheme {
        Column(
            Modifier.padding(DesignSystem.Padding.Padding2XL),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Padding.Padding2XL)
        ) {
            LanguageBottomSheet(
                selectedLanguage = AppLang.ARABIC,
                onDismiss = {},
                onLanguageSelected = {}
            )
        }
    }
}