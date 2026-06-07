package com.example.consumer.features.onBoarding.domain.repository

import com.example.consumer.features.onBoarding.domain.models.OnBoardingData

interface GetOnBoardingRepositoryInterface {
    fun getOnBoardingData(): List<OnBoardingData>
}