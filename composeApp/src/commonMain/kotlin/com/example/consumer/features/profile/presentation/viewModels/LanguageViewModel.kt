package com.example.consumer.features.profile.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumer.core.data.AppLang
import com.example.consumer.core.data.useCases.language.GetSelectedLanguageUseCase
import com.example.consumer.core.data.useCases.language.SaveLanguageOnlyUseCase
import com.example.consumer.features.profile.domain.models.LanguageUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ProfileLanguageViewModel(
    private val saveLanguageOnlyUseCase: SaveLanguageOnlyUseCase,
    private val getSelectedLanguageUseCase: GetSelectedLanguageUseCase
) : ViewModel() {

    private val _selectedLanguage = MutableStateFlow(LanguageUiState())
    val selectedLanguage = _selectedLanguage.asStateFlow()

    init {
        viewModelScope.launch {
            getSelectedLanguageUseCase().collectLatest {
                _selectedLanguage.value = _selectedLanguage.value.copy(appLang = it)
            }
        }
    }

    fun changeLanguage(language: AppLang) {
        viewModelScope.launch {
            saveLanguageOnlyUseCase(language.code)
            closeBottomSheet()
        }

    }

    fun openBottomSheet(){
        _selectedLanguage.value = _selectedLanguage.value.copy(isBottomSheetOpened = true)
    }
    fun closeBottomSheet(){
        _selectedLanguage.value = _selectedLanguage.value.copy(isBottomSheetOpened = false)
    }
}

