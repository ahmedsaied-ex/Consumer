package com.example.consumer.features.completeProfile.presentation.viewModel

import androidx.lifecycle.viewModelScope
import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.DispatcherProvider
import com.example.consumer.core.domain.utils.CostumeLogger
import com.example.consumer.core.presentation.base.BaseViewModel
import com.example.consumer.core.domain.model.FirstNameValidator
import com.example.consumer.core.domain.model.IqamaValidator
import com.example.consumer.core.domain.model.LastNameValidator
import com.example.consumer.features.completeProfile.domain.repository.CountryRepository
import com.example.consumer.features.completeProfile.data.model.Gender
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

class CompleteProfileViewModel(
    dispatcherProvider: DispatcherProvider,
    logger: CostumeLogger,
    val firstNameValidator: FirstNameValidator,
    val lastNameValidator: LastNameValidator,
    private val countryRepository: CountryRepository,
    val iqamaValidator: IqamaValidator,
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
        _state.update {
            val nextOpen = !it.countryDropdownOpen
            val nextError = if (!nextOpen && it.selectedCountry == null) "Country is required." else it.countryError
            it.copy(
                countryDropdownOpen = nextOpen,
                countryError = nextError
            )
        }
    }

    fun closeCountryDropdown() {
        _state.update {
            val nextError = if (it.countryDropdownOpen && it.selectedCountry == null) "Country is required." else it.countryError
            it.copy(
                countryDropdownOpen = false,
                countryError = nextError
            )
        }
    }

    // ── validation on submit ──────────────────────────────────────────────────

    fun validateCountry(): Boolean {
        val valid = _state.value.selectedCountry != null
        if (!valid) {
            _state.update { it.copy(countryError = "Country is required.") }
        }
        return valid
    }

    fun validateIqama(value: String) {
        val result = iqamaValidator.validate(value)
        _state.update {
            it.copy(
                iqamaNumber = it.iqamaNumber.copy(
                    value = value,
                    error = result.errorMessage,
                )
            )
        }
    }
    // ── date of birth ─────────────────────────────────────────────────────────
    fun formatDate(epochMillis: Long): String {
        val date = Instant.fromEpochMilliseconds(epochMillis)
            .toLocalDateTime(TimeZone.currentSystemDefault())

        return "${date.dayOfMonth.toString().padStart(2, '0')} / " +
                "${date.monthNumber.toString().padStart(2, '0')} / " +
                date.year
    }
    fun openDatePicker()  = _state.update { it.copy(datePickerOpen = true) }
    fun closeDatePicker() {
        _state.update {
            val nextError = if (it.dateOfBirthMillis == null) {
                "Date of birth is required and must be valid."
            } else {
                it.dateOfBirthError
            }
            it.copy(
                datePickerOpen = false,
                dateOfBirthError = nextError
            )
        }
    }

    fun onDateSelected(epochMillis: Long) {
        val formatted = formatDate(epochMillis)

        _state.update {
            it.copy(
                dateOfBirthMillis = epochMillis,
                dateOfBirthDisplay = formatted,
                dateOfBirthError = null
            )
        }
    }

    private fun validateDateOfBirth(): Boolean {
        val selected = _state.value.dateOfBirthMillis
        return if (selected == null) {
            _state.update { it.copy(dateOfBirthError = "Date of birth is required and must be valid.") }
            false
        } else {
            true
        }
    }
    fun selectGender(gender: Gender) {
        _state.update {
            it.copy(selectedGender = gender)
        }
    }
    fun isFormValid(): Boolean {
        val state = _state.value

        return state.firstName.value.isNotBlank() &&
                state.firstName.error == null &&
                state.lastName.value.isNotBlank() &&
                state.lastName.error == null &&
                state.selectedCountry != null &&
                state.iqamaNumber.value.isNotBlank() &&
                state.iqamaNumber.error == null &&
                state.dateOfBirthMillis != null
    }

}
