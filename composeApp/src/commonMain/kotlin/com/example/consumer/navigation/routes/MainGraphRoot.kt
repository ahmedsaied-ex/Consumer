package com.example.consumer.navigation.routes

import kotlinx.serialization.Serializable

sealed interface MainGraphRoot {
    @Serializable
    data object MainGraph : MainGraphRoot

}