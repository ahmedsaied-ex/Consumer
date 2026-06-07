package com.example.consumer.features.onBoarding.presintation.viewModels

import androidx.lifecycle.viewModelScope
import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.DispatcherProvider
import com.example.consumer.core.domain.utils.CostumeLogger
import com.example.consumer.core.presentation.base.BaseViewModel
import com.example.consumer.features.onBoarding.domain.models.OnBoardingData
import com.example.consumer.features.onBoarding.domain.useCases.GetOnBoardingDataInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OnBoardingViewModel(
      dispatcherProvider: DispatcherProvider,
      logger: CostumeLogger,
      analytics: AnalyticsLogger,
    val getOnBoardingDataInterface: GetOnBoardingDataInterface
) : BaseViewModel(dispatcherProvider = dispatcherProvider, logger = logger, analytics = analytics) {

    private val _item = MutableStateFlow<List<OnBoardingData>>(emptyList())
    val item: StateFlow<List<OnBoardingData>> = _item

    init {
        load()
    }

    fun load() {
      launchSafe { _item.value = getOnBoardingDataInterface() }
    }


}