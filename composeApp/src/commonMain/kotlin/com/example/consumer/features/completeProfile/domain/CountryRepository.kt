package com.example.consumer.features.completeProfile.domain

import com.example.consumer.features.completeProfile.data.CountryData

interface CountryRepository {
    suspend fun getCountries(): List<CountryData>
}
