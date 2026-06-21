package com.example.consumer.features.splashScreen.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.DispatcherProvider
import com.example.consumer.core.domain.utils.CostumeLogger
import com.example.consumer.core.presentation.base.BaseViewModel
import com.example.consumer.features.splashScreen.domain.model.SplashDestination
import com.example.consumer.features.splashScreen.domain.usecase.GetSplashDestinationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashScreenViewModel(
    private val getSplashDestinationUseCase: GetSplashDestinationUseCase,
    dispatcherProvider: DispatcherProvider,
    logger: CostumeLogger,
    analytics: AnalyticsLogger,
) : BaseViewModel(dispatcherProvider = dispatcherProvider, logger = logger, analytics = analytics) {

    private val _destination = MutableStateFlow<SplashDestination?>(null)
    val destination: StateFlow<SplashDestination?> = _destination.asStateFlow()

    private var collectionJob: kotlinx.coroutines.Job? = null

    init {
        println("SplashViewModel: INIT called")
        startCollecting()
    }

    private fun startCollecting() {
        collectionJob?.cancel()
        println("SplashViewModel: startCollecting - about to launch")

        collectionJob = viewModelScope.launch {
            println("SplashViewModel: Inside viewModelScope.launch")
            try {
                println("SplashViewModel: Calling getSplashDestinationUseCase().collect()")
                getSplashDestinationUseCase().collect { dest ->
                    println("SplashViewModel: RECEIVED DESTINATION: $dest")
                    _destination.value = dest
                }
            } catch (e: Exception) {
                println("SplashViewModel: EXCEPTION: ${e.message}")
            }
        }
        println("SplashViewModel: Launch call completed")
    }

    fun refreshDestination() {
        println("SplashViewModel: refreshDestination called - rechecking current state")
        _destination.value = null // Reset to force fresh check
        startCollecting()
    }
}
