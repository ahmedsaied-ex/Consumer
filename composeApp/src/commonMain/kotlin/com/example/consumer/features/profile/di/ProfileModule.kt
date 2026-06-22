package com.example.consumer.features.profile.di

import com.example.consumer.features.profile.presentation.viewModels.ProfileLanguageViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val profileModule= module {
    viewModelOf(::ProfileLanguageViewModel)
}