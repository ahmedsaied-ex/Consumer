package com.example.consumer.features.onBoarding.presintation.viewModels

import com.example.consumer.core.domain.dataStorage.Data
import com.example.consumer.core.domain.dataStorage.UserDto
import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.DispatcherProvider
import com.example.consumer.core.domain.utils.CostumeLogger
import com.example.consumer.core.presentation.base.BaseViewModel
import com.example.consumer.core.presentation.components.tabBar.TabItem
import com.example.consumer.features.onBoarding.domain.models.OnBoardingUiState
import com.example.consumer.features.onBoarding.domain.useCases.GetOnBoardingDataInterface
import com.example.consumer.features.onBoarding.domain.useCases.SetUserDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


class OnBoardingViewModel(
    dispatcherProvider: DispatcherProvider,
    logger: CostumeLogger,
    analytics: AnalyticsLogger,
    val getOnBoardingDataInterface: GetOnBoardingDataInterface,
    val setUserDataUseCase: SetUserDataUseCase
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


    fun testSetData(){
        val fakeData = Data(
            token = "112233",
            user = UserDto(
                balance = 12.3,
                created_at = "asdsad",
                email = "asdasd",
                firstname = "asdasdsa",
                id = "asdasdsad",
                image = "asdasdasd",
                is_active = 1,
                is_anonymous = 0,
                is_profile_completed = false,
                language = "asdasd",
                lastname = "asdasd",
                phone = "asdasd",
                phone_code = "asdasdasd",
                role_code = "asdasdasd"
            )
        )


        launchSafe{ setUserDataUseCase.invoke(fakeData) }
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