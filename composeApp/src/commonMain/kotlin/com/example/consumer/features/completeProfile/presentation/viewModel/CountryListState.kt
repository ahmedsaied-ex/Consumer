package com.example.consumer.features.completeProfile.presentation.viewModel

import com.example.consumer.features.completeProfile.data.model.CountryData


/**
 * Tracks async loading of the countries list.
 */
sealed interface CountryListState {
    data object Idle    : CountryListState
    data object Loading : CountryListState
    data class  Success(val countries: List<CountryData>) : CountryListState
    data class  Error(val message: String)                : CountryListState
}
