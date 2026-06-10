package com.example.consumer.features.onBoarding.data.repository

import com.example.consumer.features.onBoarding.data.dataSource.OnBoardingDataSource
import com.example.consumer.features.onBoarding.domain.models.OnBoardingData
import com.example.consumer.features.onBoarding.domain.repository.GetOnBoardingRepositoryInterface

class GetOnBoardingRepositoryImplementation(val onBoardingDataSource: OnBoardingDataSource) :
    GetOnBoardingRepositoryInterface {
    override fun getOnBoardingData(): List<OnBoardingData> {
        return onBoardingDataSource.getOnBoardingData()
    }
}