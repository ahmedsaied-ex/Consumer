package com.example.consumer.features.profile.domain.models

import com.example.consumer.core.presentation.utils.UiText

data class UserProfileUiState(
    val isError: Boolean = false,
    val error : UiText? =null,
    val isLoading: Boolean = false,
    val consumerData: ConsumerDomain?=null
)
