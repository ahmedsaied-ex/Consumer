package com.example.consumer.features.completeProfile.di

import com.example.consumer.core.domain.model.FirstNameValidator
import com.example.consumer.core.domain.model.LastNameValidator
import com.example.consumer.features.completeProfile.data.repository.CountryRepositoryImpl
import com.example.consumer.features.completeProfile.domain.CountryRepository
import com.example.consumer.features.completeProfile.viewModel.CompleteProfileViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val CompleteProfileDi = module {
    singleOf(::CountryRepositoryImpl) { bind<CountryRepository>() }
    factoryOf(::FirstNameValidator)
    factoryOf(::LastNameValidator)
    viewModelOf(::CompleteProfileViewModel)
}
