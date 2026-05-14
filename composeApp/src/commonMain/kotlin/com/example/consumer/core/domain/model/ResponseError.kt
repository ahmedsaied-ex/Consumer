package com.example.consumer.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseError(
    val field: String,
    val massage: String
)
