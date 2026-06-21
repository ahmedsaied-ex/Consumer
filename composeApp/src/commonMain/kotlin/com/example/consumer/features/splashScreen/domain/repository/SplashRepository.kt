package com.example.consumer.features.splashScreen.domain.repository

import com.example.consumer.features.splashScreen.domain.model.SplashDestination
import kotlinx.coroutines.flow.Flow

interface SplashRepository {
    fun getSplashDestination(): Flow<SplashDestination>
}
