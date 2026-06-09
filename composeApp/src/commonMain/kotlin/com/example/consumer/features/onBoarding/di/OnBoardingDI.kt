package com.example.consumer.features.onBoarding.di

import com.example.consumer.features.onBoarding.data.dataSource.OnBoardingDataSource
import com.example.consumer.features.onBoarding.data.repository.GetOnBoardingRepositoryImplementation
import com.example.consumer.features.onBoarding.data.useCases.GetOnBoardingInterfaceImplementation
import com.example.consumer.features.onBoarding.domain.repository.GetOnBoardingRepositoryInterface
import com.example.consumer.features.onBoarding.domain.useCases.GetOnBoardingDataInterface
import com.example.consumer.features.onBoarding.presintation.viewModels.OnBoardingViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val OnBoardingModule= module {
    singleOf(::OnBoardingDataSource)
    singleOf(::GetOnBoardingRepositoryImplementation) {bind<GetOnBoardingRepositoryInterface>()}
    singleOf(::GetOnBoardingInterfaceImplementation) {bind<GetOnBoardingDataInterface>()}
    viewModelOf(::OnBoardingViewModel)

}