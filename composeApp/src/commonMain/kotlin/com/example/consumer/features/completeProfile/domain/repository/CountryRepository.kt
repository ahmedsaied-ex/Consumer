package com.example.consumer.features.completeProfile.domain.repository

import com.example.consumer.features.completeProfile.data.model.CountryData

interface CountryRepository {
    suspend fun getCountries(): List<CountryData>
}