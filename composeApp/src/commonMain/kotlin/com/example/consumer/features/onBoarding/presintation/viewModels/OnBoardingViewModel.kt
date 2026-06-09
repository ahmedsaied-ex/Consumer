package com.example.consumer.features.onBoarding.presintation.viewModels

import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.DispatcherProvider
import com.example.consumer.core.domain.utils.CostumeLogger
import com.example.consumer.core.presentation.base.BaseViewModel
import com.example.consumer.core.presentation.components.tabBar.TabItem
import com.example.consumer.features.onBoarding.domain.models.OnBoardingUiState
import com.example.consumer.features.onBoarding.domain.useCases.GetOnBoardingDataInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class OnBoardingViewModel(
    dispatcherProvider: DispatcherProvider,
    logger: CostumeLogger,
    analytics: AnalyticsLogger,
    val getOnBoardingDataInterface: GetOnBoardingDataInterface
) : BaseViewModel(dispatcherProvider = dispatcherProvider, logger = logger, analytics = analytics) {

    private val _onBoardingUiState = MutableStateFlow<OnBoardingUiState>(OnBoardingUiState())
    val onBoardingUiState: StateFlow<OnBoardingUiState> = _onBoardingUiState

    init {
        load()
    }

    fun load() {
        launchSafe {
            _onBoardingUiState.update {
                _onBoardingUiState.value.copy(onBoardingScreens = getOnBoardingDataInterface())
            }
        }
    }

    fun onTabSelected(selectedTap: TabItem) {
        _onBoardingUiState.update {
            it.copy(selectedTabId = selectedTap.id)
        }
    }

    fun openBottomSheet(){
        _onBoardingUiState.update {
            it.copy(isBottomSheetOpened = true)
        }

    }

    fun closeBottomSheet(){
        _onBoardingUiState.update {
            it.copy(isBottomSheetOpened = false)
        }


    }

}