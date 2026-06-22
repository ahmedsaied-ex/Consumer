package com.example.consumer.features.profile.presentation.viewModels

import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.DispatcherProvider
import com.example.consumer.core.domain.utils.CostumeLogger
import com.example.consumer.core.presentation.base.BaseViewModel
import com.example.consumer.features.profile.domain.models.UserProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserProfileViewModel(
      dispatcherProvider: DispatcherProvider,
      logger: CostumeLogger,
      analytics: AnalyticsLogger,
) : BaseViewModel(dispatcherProvider = dispatcherProvider, logger = logger, analytics = analytics) {

    private val _uiState = MutableStateFlow(UserProfileUiState())
    val uiState = _uiState.asStateFlow()



}