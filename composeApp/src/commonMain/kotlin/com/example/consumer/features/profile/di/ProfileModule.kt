package com.example.consumer.features.profile.di

import com.example.consumer.features.profile.data.dataSource.GetConsumerDataDataSource
import com.example.consumer.features.profile.data.repository.GetConsumerDataRepositoryImpl
import com.example.consumer.features.profile.data.useCases.GetConsumerDataUseCaseImpl
import com.example.consumer.features.profile.domain.repository.GetConsumerDataRepository
import com.example.consumer.features.profile.domain.useCases.GetConsumerDataUseCase
import com.example.consumer.features.profile.presentation.viewModels.ProfileLanguageViewModel
import com.example.consumer.features.profile.presentation.viewModels.UserProfileViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val profileModule= module {
    viewModelOf(::ProfileLanguageViewModel)
    viewModelOf(::UserProfileViewModel)
    singleOf(::GetConsumerDataDataSource)
    singleOf(::GetConsumerDataRepositoryImpl) { bind<GetConsumerDataRepository>() }
    singleOf(::GetConsumerDataUseCaseImpl) { bind<GetConsumerDataUseCase>() }
}