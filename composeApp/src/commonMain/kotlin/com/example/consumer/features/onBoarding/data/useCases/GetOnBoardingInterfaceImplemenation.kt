package com.example.consumer.features.onBoarding.data.useCases

import com.example.consumer.features.onBoarding.domain.models.OnBoardingData
import com.example.consumer.features.onBoarding.domain.repository.GetOnBoardingRepositoryInterface
import com.example.consumer.features.onBoarding.domain.useCases.GetOnBoardingDataInterface

class GetOnBoardingInterfaceImplementation(val getOnBoardingRepositoryInterface: GetOnBoardingRepositoryInterface) : GetOnBoardingDataInterface {
    override suspend fun invoke(): List<OnBoardingData> {
        return getOnBoardingRepositoryInterface.getOnBoardingData()
    }
}