package com.example.consumer.features.onBoarding.domain.useCases

import com.example.consumer.core.domain.dataStorage.Data

interface SetUserDataUseCase{
    suspend operator fun invoke(data : Data)
}