package com.example.consumer.features.splashScreen.di

import com.example.consumer.features.splashScreen.data.SplashRepositoryImpl
import com.example.consumer.features.splashScreen.domain.repository.SplashRepository
import com.example.consumer.features.splashScreen.domain.usecase.GetSplashDestinationUseCase
import com.example.consumer.features.splashScreen.presentation.viewModel.SplashScreenViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val splashModule = module {
    singleOf(::SplashRepositoryImpl) bind SplashRepository::class
    singleOf(::GetSplashDestinationUseCase)
    factoryOf(::SplashScreenViewModel)
}
