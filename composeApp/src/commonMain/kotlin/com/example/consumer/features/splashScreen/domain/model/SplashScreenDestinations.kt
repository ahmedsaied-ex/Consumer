package com.example.consumer.features.splashScreen.domain.model


sealed interface SplashDestination {
    data object LanguageSelection : SplashDestination
    data object Auth : SplashDestination
    data object Home : SplashDestination
}
