package com.example.consumer.features.profile.data.repository

import com.example.consumer.core.domain.model.CostumeResult
import com.example.consumer.core.domain.model.DataError
import com.example.consumer.core.domain.model.map
import com.example.consumer.core.domain.utils.Error
import com.example.consumer.features.profile.data.dataSource.GetConsumerDataDataSource
import com.example.consumer.features.profile.domain.models.ConsumerDomain
import com.example.consumer.features.profile.domain.models.GetConsumerDTO
import com.example.consumer.features.profile.domain.repository.GetConsumerDataRepository
import com.example.consumer.features.profile.domain.utils.toDomain

class GetConsumerDataRepositoryImpl(val dataSource: GetConsumerDataDataSource) :
    GetConsumerDataRepository {

    override suspend fun getProfile(): CostumeResult<ConsumerDomain, DataError.Remote> =
        dataSource.getProfile().map { it.toDomain() }
}

