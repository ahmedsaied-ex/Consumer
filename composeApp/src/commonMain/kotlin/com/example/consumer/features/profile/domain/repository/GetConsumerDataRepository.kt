package com.example.consumer.features.profile.domain.repository

import com.example.consumer.core.domain.model.CostumeResult
import com.example.consumer.core.domain.model.DataError
import com.example.consumer.features.profile.domain.models.ConsumerDomain
import com.example.consumer.features.profile.domain.models.GetConsumerDTO

interface GetConsumerDataRepository{
    suspend fun getProfile() : CostumeResult<ConsumerDomain, DataError.Remote>
}