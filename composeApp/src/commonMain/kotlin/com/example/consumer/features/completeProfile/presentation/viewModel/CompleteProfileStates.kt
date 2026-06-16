package com.example.consumer.features.completeProfile.presentation.viewModel

import com.example.consumer.core.presentation.components.TextFieldUiState
import com.example.consumer.features.completeProfile.data.model.CountryData
import com.example.consumer.features.completeProfile.data.model.Gender

data class CompleteProfileStates(
    val firstName: TextFieldUiState = TextFieldUiState(),
    val lastName: TextFieldUiState = TextFieldUiState(),
    val iqamaNumber: TextFieldUiState = TextFieldUiState(),
    val countriesState: CountryListState = CountryListState.Idle,
    val selectedCountry: CountryData? = null,
    val countryDropdownOpen: Boolean = false,
    val countryError: String? = null,

    // ── date of birth ─────────────────────────────────────────────────────────
    val dateOfBirthMillis: Long? = null,   // raw value used for logic/submit
    val dateOfBirthDisplay: String = "",     // formatted string shown in the field
    val dateOfBirthError: String? = null,
    val datePickerOpen: Boolean = false,

    val selectedGender: Gender = Gender.MALE, ){
    val isFormValid: Boolean
        get() =
            firstName.value.isNotBlank() &&
                    firstName.error == null &&
                    lastName.value.isNotBlank() &&
                    lastName.error == null &&
                    selectedCountry != null &&
                    iqamaNumber.value.isNotBlank() &&
                    iqamaNumber.error == null &&
                    dateOfBirthMillis != null
}