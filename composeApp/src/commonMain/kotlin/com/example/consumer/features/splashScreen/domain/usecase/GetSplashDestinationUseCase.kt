package com.example.consumer.features.splashScreen.domain.usecase

import com.example.consumer.features.splashScreen.domain.model.SplashDestination
import com.example.consumer.features.splashScreen.domain.repository.SplashRepository
import kotlinx.coroutines.flow.Flow

class GetSplashDestinationUseCase(
    private val splashRepository: SplashRepository
) {
    operator fun invoke(): Flow<SplashDestination> = splashRepository.getSplashDestination()
}

