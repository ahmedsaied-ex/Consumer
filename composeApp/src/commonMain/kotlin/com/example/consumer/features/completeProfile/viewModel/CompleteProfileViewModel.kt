package com.example.consumer.features.completeProfile.viewModel

import androidx.lifecycle.viewModelScope
import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.DispatcherProvider
import com.example.consumer.core.domain.utils.CostumeLogger
import com.example.consumer.core.presentation.base.BaseViewModel
import com.example.consumer.core.domain.model.FirstNameValidator
import com.example.consumer.core.domain.model.LastNameValidator
import com.example.consumer.features.completeProfile.domain.CountryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CompleteProfileViewModel(
    dispatcherProvider: DispatcherProvider,
    logger: CostumeLogger,
    val firstNameValidator: FirstNameValidator,
    val lastNameValidator: LastNameValidator,
    private val countryRepository: CountryRepository,
    analytics: AnalyticsLogger,
) : BaseViewModel(dispatcherProvider = dispatcherProvider, logger = logger, analytics = analytics) {

    private val _state = MutableStateFlow(CompleteProfileStates())
    val state = _state.asStateFlow()

    init {
        loadCountries()
    }

    fun validateFirstName(value: String) {

        val result = firstNameValidator.validate(value)

        _state.update {
            it.copy(
                firstName = it.firstName.copy(
                    value = value,
                    error = result.errorMessage
                )
            )
        }
    }

    fun validateLastName(value: String) {

        val result = lastNameValidator.validate(value)

        _state.update {
            it.copy(
                lastName = it.lastName.copy(
                    value = value,
                    error = result.errorMessage
                )
            )
        }
    }

    private fun loadCountries() {
        viewModelScope.launch(dispatcherProvider.io) {
            _state.update { it.copy(countriesState = CountryListState.Loading) }
            try {
                val countries = countryRepository.getCountries()
                _state.update { it.copy(countriesState = CountryListState.Success(countries)) }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        countriesState = CountryListState.Error(
                            e.message ?: "Failed to load countries"
                        )
                    )
                }
            }
        }
    }

    fun retryLoadCountries() = loadCountries()

    fun onCountrySelected(id: Int) {
        val countries = (_state.value.countriesState as? CountryListState.Success)?.countries
            ?: return
        val country = countries.firstOrNull { it.id == id } ?: return
        _state.update {
            it.copy(
                selectedCountry     = country,
                countryDropdownOpen = false,
                countryError        = null,
            )
        }
    }

    fun toggleCountryDropdown() {
        _state.update { it.copy(countryDropdownOpen = !it.countryDropdownOpen) }
    }

    fun closeCountryDropdown() {
        _state.update { it.copy(countryDropdownOpen = false) }
    }

    // ── validation on submit ──────────────────────────────────────────────────

    fun validateCountry(): Boolean {
        val valid = _state.value.selectedCountry != null
        if (!valid) {
            _state.update { it.copy(countryError = "Please select a country") }
        }
        return valid
    }

}
