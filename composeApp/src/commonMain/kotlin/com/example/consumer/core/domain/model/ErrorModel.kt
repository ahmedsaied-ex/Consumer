package com.example.consumer.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorModel(
    val errors: List<ResponseError>
)