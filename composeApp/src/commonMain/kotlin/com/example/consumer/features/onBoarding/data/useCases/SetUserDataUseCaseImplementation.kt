package com.example.consumer.features.onBoarding.data.useCases

import com.example.consumer.core.domain.dataStorage.Data
import com.example.consumer.core.domain.dataStorage.SessionStorage
import com.example.consumer.features.onBoarding.domain.useCases.SetUserDataUseCase

class SetUserDataUseCaseImplementation(private val sessionStorage: SessionStorage) :
    SetUserDataUseCase {
    override suspend fun invoke(data: Data) {
        sessionStorage.set(data)
    }
}