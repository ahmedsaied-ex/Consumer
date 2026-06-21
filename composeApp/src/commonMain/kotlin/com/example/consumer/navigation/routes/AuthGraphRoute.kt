package com.example.consumer.navigation.routes

import kotlinx.serialization.Serializable


sealed interface AuthGraphRout {
    @Serializable
    data object AuthGraph : AuthGraphRout

    @Serializable
    data object OnBoardingScreen :AuthGraphRout
}