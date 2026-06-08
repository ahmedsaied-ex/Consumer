//package com.auctionex.expertapps.features.languageSelection.presentation.viewModel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.auctionex.expertapps.core.domain.model.AppLang
//import com.auctionex.expertapps.core.domain.usecase.GetSelectedLanguageUseCase
//import com.auctionex.expertapps.core.domain.usecase.SaveLanguageOnlyUseCase
//import com.auctionex.expertapps.features.languageSelection.domain.useCase.ConfirmLanguageSelectionUseCase
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//class LanguageViewModel(
//    private val saveLanguageOnlyUseCase: SaveLanguageOnlyUseCase,
//    private val getSelectedLanguageUseCase: GetSelectedLanguageUseCase,
//    private val confirmLanguageSelectionUseCase: ConfirmLanguageSelectionUseCase
//) : ViewModel() {
//
//    private val _selectedLanguage = MutableStateFlow(AppLang.ENGLISH)
//    val selectedLanguage = _selectedLanguage.asStateFlow()
//
//    init {
//        viewModelScope.launch {
//            getSelectedLanguageUseCase().collectLatest {
//                _selectedLanguage.value = it
//            }
//        }
//    }
//
//    fun onLanguageSelected(language: AppLang) {
//        _selectedLanguage.value = language
//        viewModelScope.launch {
//            saveLanguageOnlyUseCase(language.code)
//        }
//    }
//
//    fun onContinue(onComplete: () -> Unit) {
//        viewModelScope.launch {
//            val languageCode = selectedLanguage.value.code
//            try {
//                // Use atomic operation: save language and mark as selected in one transaction
//                confirmLanguageSelectionUseCase.confirmWithLanguage(languageCode)
//            } catch (e: Exception) {
//                // Fallback: try separate operations if atomic operation fails
//                saveLanguageOnlyUseCase(languageCode)
//                confirmLanguageSelectionUseCase()
//            }
//            onComplete()
//        }
//    }
//}
