package com.example.consumer.features.profile.domain.models

import kotlinx.serialization.Serializable

@Serializable

data class Country(
    val countryCode: String?,
    val id: Int?,
    val name: String?
)