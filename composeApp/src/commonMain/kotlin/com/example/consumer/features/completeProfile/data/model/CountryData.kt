package com.example.consumer.features.completeProfile.data.model

data class CountryData(
    val id: Int,
    val name: String,
    val code: String,   // e.g. "EG", "US"
    val flag: String    // emoji flag, e.g. "🇪🇬"
)