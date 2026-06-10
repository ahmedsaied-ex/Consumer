package com.example.consumer.features.completeProfile.viewModel

import com.example.consumer.core.presentation.components.TextFieldUiState
import com.example.consumer.features.completeProfile.data.CountryData

data class CompleteProfileStates(
    val firstName: TextFieldUiState = TextFieldUiState(),
    val lastName: TextFieldUiState = TextFieldUiState(),
    val countriesState:      CountryListState = CountryListState.Idle,
    val selectedCountry:     CountryData?     = null,
    val countryDropdownOpen: Boolean          = false,
    val countryError:        String?          = null,
    )