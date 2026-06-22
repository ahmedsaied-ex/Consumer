package com.example.consumer.features.profile.domain.models

import com.example.consumer.core.data.AppLang

data class LanguageUiState (
    val appLang : AppLang= AppLang.ARABIC,
    val isBottomSheetOpened: Boolean= false

)