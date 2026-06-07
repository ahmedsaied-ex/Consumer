package com.example.consumer.core.di

import com.example.consumer.features.onBoarding.di.OnBoardingModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            platformModule,
            coreModule,
            OnBoardingModule
            )
    }

expect val platformModule: Module
