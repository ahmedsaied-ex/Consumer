package com.example.consumer.features.completeProfile.data.repository

import com.example.consumer.features.completeProfile.data.CountryData
import com.example.consumer.features.completeProfile.domain.CountryRepository
import kotlinx.coroutines.delay

class CountryRepositoryImpl : CountryRepository {

    override suspend fun getCountries(): List<CountryData> {
        delay(800) // simulate network
        return DUMMY_COUNTRIES
    }

    companion object {
        val DUMMY_COUNTRIES = listOf(
            CountryData(1,  "Egypt",          "EG", "🇪🇬"),
            CountryData(2,  "Saudi Arabia",   "SA", "🇸🇦"),
            CountryData(3,  "United States",  "US", "🇺🇸"),
            CountryData(4,  "United Kingdom", "GB", "🇬🇧"),
            CountryData(5,  "Germany",        "DE", "🇩🇪"),
            CountryData(6,  "France",         "FR", "🇫🇷"),
            CountryData(7,  "Jordan",         "JO", "🇯🇴"),
            CountryData(8,  "Kuwait",         "KW", "🇰🇼"),
            CountryData(9,  "UAE",            "AE", "🇦🇪"),
            CountryData(10, "Canada",         "CA", "🇨🇦"),
            CountryData(11, "Australia",      "AU", "🇦🇺"),
            CountryData(12, "Turkey",         "TR", "🇹🇷"),
            CountryData(13, "Morocco",        "MA", "🇲🇦"),
            CountryData(14, "Lebanon",        "LB", "🇱🇧"),
            CountryData(15, "Qatar",          "QA", "🇶🇦"),
        )
    }
}
