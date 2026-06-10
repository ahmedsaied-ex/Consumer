package com.example.consumer.features.completeProfile.viewModel

import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.DispatcherProvider
import com.example.consumer.core.domain.utils.CostumeLogger
import com.example.consumer.core.presentation.base.BaseViewModel
import com.example.consumer.core.domain.model.FirstNameValidator
import com.example.consumer.core.domain.model.LastNameValidator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CompleteProfileViewModel(
    dispatcherProvider: DispatcherProvider,
    logger: CostumeLogger,
    val firstNameValidator: FirstNameValidator,
    val lastNameValidator: LastNameValidator,
    analytics: AnalyticsLogger,
) : BaseViewModel(dispatcherProvider = dispatcherProvider, logger = logger, analytics = analytics) {

    private val _state = MutableStateFlow(CompleteProfileStates())
    val state = _state.asStateFlow()

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
}
