package com.example.consumer.features.completeProfile.viewModel

import com.example.consumer.core.presentation.components.TextFieldUiState

data class CompleteProfileStates(
    val firstName: TextFieldUiState = TextFieldUiState(),
    val lastName: TextFieldUiState = TextFieldUiState(),
    )