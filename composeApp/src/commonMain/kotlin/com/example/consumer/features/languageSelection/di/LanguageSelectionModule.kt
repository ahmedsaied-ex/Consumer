package com.example.consumer.features.languageSelection.di

import com.example.consumer.features.languageSelection.data.usecase.ConfirmLanguageSelectionUseCaseImpl
import com.example.consumer.features.languageSelection.domain.ConfirmLanguageSelectionUseCase
import com.example.consumer.features.languageSelection.presentation.viewModel.LanguageViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val languageSelectionModule = module {
    singleOf(::LanguageViewModel)
    singleOf(::ConfirmLanguageSelectionUseCaseImpl) {  bind <ConfirmLanguageSelectionUseCase>()}



}
