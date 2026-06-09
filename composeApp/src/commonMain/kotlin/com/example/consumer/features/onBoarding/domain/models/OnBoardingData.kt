package com.example.consumer.features.onBoarding.domain.models

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class OnBoardingData(
    val image: DrawableResource,
    val title: StringResource,
    val description: StringResource,
)