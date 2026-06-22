package com.example.consumer.features.profile.domain.useCases

import com.example.consumer.core.domain.model.CostumeResult
import com.example.consumer.core.domain.model.DataError
import com.example.consumer.features.profile.domain.models.ConsumerDomain
import com.example.consumer.features.profile.domain.models.GetConsumerDTO

interface GetConsumerDataUseCase {
    suspend fun getConsumerData(): CostumeResult<ConsumerDomain, DataError.Remote>
}