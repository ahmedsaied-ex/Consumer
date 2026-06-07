package com.example.consumer.features.onBoarding.domain.useCases

import com.example.consumer.features.onBoarding.domain.models.OnBoardingData

interface GetOnBoardingDataInterface {
    suspend operator fun invoke(): List<OnBoardingData>
}