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


    fun testSetData() {
        val fakeData = Data(
            token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiYWhtZWRkYXJkZXJ5QHlvcG1haWwuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvZW1haWxhZGRyZXNzIjoiYWhtZWRkYXJkZXJ5QHlvcG1haWwuY29tIiwiRnVsbE5hbWUiOiJhaG1lZCBkYXJkZXJ5IiwiVXNlclR5cGUiOiJDT05TVU1FUiIsIkxhc3RVcGRhdGUiOiI2MzkxNzczNDI1Mjk2NTMwNTYiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6ImI5MWFiNjU3LTkyYzYtNGQ0Mi04MDJiLTM2ZWJlYzA4OGZiMSIsInN1YiI6ImI5MWFiNjU3LTkyYzYtNGQ0Mi04MDJiLTM2ZWJlYzA4OGZiMSIsIkFjdGl2ZVNsYSI6InRydWUiLCJqdGkiOiI0YzcxM2Q2NS01MzU0LTRlY2EtYWE4YS04N2YzZDlhNWU3ZmMiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJDb25zdW1lciIsImV4cCI6MTc4MjE2OTg1MiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo2MTk1NSIsImF1ZCI6Imh0dHA6Ly9sb2NhbGhvc3Q6NDIwMCJ9.c0OvNJfkVhiei3jnlP8MlBGXbQTumcBSwfkyomzGs5c",
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


        launchSafe { setUserDataUseCase.invoke(fakeData) }
    }

    fun onTabSelected(selectedTap: TabItem) {
        _onBoardingUiState.update {
            it.copy(selectedTabId = selectedTap.id)
        }
    }

    fun openBottomSheet() {
        _onBoardingUiState.update {
            it.copy(isBottomSheetOpened = true)
        }

    }

    fun closeBottomSheet() {
        _onBoardingUiState.update {
            it.copy(isBottomSheetOpened = false)
        }


    }

}