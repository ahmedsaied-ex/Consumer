package com.example.consumer.navigation.routes

import kotlinx.serialization.Serializable

sealed interface SplashRoute {
    @Serializable
    data object Splash : SplashRoute

    @Serializable
    data object LanguageSelection : SplashRoute
}
