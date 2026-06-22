package com.example.consumer.features.profile.presentation.viewModels

import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.CostumeResult
import com.example.consumer.core.domain.model.DispatcherProvider
import com.example.consumer.core.domain.model.onError
import com.example.consumer.core.domain.model.onSuccess
import com.example.consumer.core.domain.utils.CostumeLogger
import com.example.consumer.core.domain.utils.toUiText
import com.example.consumer.core.presentation.base.BaseViewModel
import com.example.consumer.features.profile.domain.models.UserProfileUiState
import com.example.consumer.features.profile.domain.useCases.GetConsumerDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserProfileViewModel(
    val consumerDataUseCase: GetConsumerDataUseCase,
    dispatcherProvider: DispatcherProvider,
    logger: CostumeLogger,
    analytics: AnalyticsLogger,
) : BaseViewModel(dispatcherProvider = dispatcherProvider, logger = logger, analytics = analytics) {

    private val _uiState = MutableStateFlow(UserProfileUiState())
    val uiState = _uiState.asStateFlow()

    init {
        launchSafe {
            _uiState.update { it.copy(isLoading = true) }

            consumerDataUseCase.getConsumerData().onError { result ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isError = true,
                        error = result.toUiText()
                    )
                }
            }.onSuccess { result ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        consumerData = result
                    )
                }
            }


        }
    }


}