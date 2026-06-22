package com.example.consumer.core.di

import com.example.consumer.features.completeProfile.di.CompleteProfileDi
import com.example.consumer.features.languageSelection.di.languageSelectionModule
import com.example.consumer.features.onBoarding.di.OnBoardingModule
import com.example.consumer.features.profile.di.profileModule
import com.example.consumer.features.splashScreen.di.splashModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            platformModule,
            coreModule,
            OnBoardingModule,
            CompleteProfileDi,
            splashModule,
            languageSelectionModule,
            profileModule,

        )
    }

expect val platformModule: Module
