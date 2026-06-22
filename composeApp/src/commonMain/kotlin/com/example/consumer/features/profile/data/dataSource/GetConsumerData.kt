package com.example.consumer.features.profile.data.dataSource

import com.example.consumer.core.data.network.ApiConfig
import com.example.consumer.core.data.network.NetworkFactory
import com.example.consumer.core.data.network.get
import com.example.consumer.core.domain.model.CostumeResult
import com.example.consumer.core.domain.model.DataError
import com.example.consumer.features.profile.domain.models.GetConsumerDTO

class GetConsumerDataDataSource(
    private val networkFactory: NetworkFactory
) {
    private val client get() = networkFactory.getClient()

    suspend fun getProfile(): CostumeResult<GetConsumerDTO, DataError.Remote> =
        client.get(
            route = ApiConfig.Endpoints.GET_USER_DATA,
        )
}