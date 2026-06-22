package com.example.consumer.features.languageSelection.presentation.viewModel

import androidx.lifecycle.viewModelScope
import com.example.consumer.core.data.AppLang
import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.DispatcherProvider
import com.example.consumer.core.domain.utils.CostumeLogger
import com.example.consumer.core.presentation.base.BaseViewModel
import com.example.consumer.core.data.useCases.language.GetSelectedLanguageUseCase
import com.example.consumer.core.data.useCases.language.SaveLanguageOnlyUseCase
import com.example.consumer.features.languageSelection.domain.ConfirmLanguageSelectionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LanguageViewModel(
    private val saveLanguageOnlyUseCase: SaveLanguageOnlyUseCase,
    private val getSelectedLanguageUseCase: GetSelectedLanguageUseCase,
    private val confirmLanguageSelectionUseCase: ConfirmLanguageSelectionUseCase,
    dispatcherProvider: DispatcherProvider,
    logger: CostumeLogger,
    analytics: AnalyticsLogger,
) : BaseViewModel(dispatcherProvider = dispatcherProvider, logger = logger, analytics = analytics) {
    private val _selectedLanguage = MutableStateFlow(AppLang.ARABIC)
    val selectedLanguage = _selectedLanguage.asStateFlow()

    init {
        viewModelScope.launch {
            getSelectedLanguageUseCase().collectLatest {
                _selectedLanguage.value = it
            }
        }
    }

    fun onLanguageSelected(language: AppLang) {
        _selectedLanguage.value = language
        viewModelScope.launch {
            saveLanguageOnlyUseCase(language.code)
        }
    }

    fun onContinue(onComplete: () -> Unit) {
        viewModelScope.launch {
            val languageCode = selectedLanguage.value.code
            try {
                // Use atomic operation: save language and mark as selected in one transaction
                confirmLanguageSelectionUseCase.confirmWithLanguage(languageCode)
            } catch (e: Exception) {
                // Fallback: try separate operations if atomic operation fails
                saveLanguageOnlyUseCase(languageCode)
                confirmLanguageSelectionUseCase()
            }
            onComplete()
        }
    }
}

