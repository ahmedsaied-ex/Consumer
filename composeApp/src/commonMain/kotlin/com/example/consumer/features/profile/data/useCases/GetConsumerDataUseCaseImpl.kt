package com.example.consumer.features.profile.data.useCases

import com.example.consumer.core.domain.model.CostumeResult
import com.example.consumer.core.domain.model.DataError
import com.example.consumer.features.profile.domain.models.ConsumerDomain
import com.example.consumer.features.profile.domain.repository.GetConsumerDataRepository
import com.example.consumer.features.profile.domain.useCases.GetConsumerDataUseCase

class GetConsumerDataUseCaseImpl(val repository: GetConsumerDataRepository) : GetConsumerDataUseCase {
    override suspend fun getConsumerData(): CostumeResult<ConsumerDomain, DataError.Remote> {
        return repository.getProfile()
    }
}