package com.example.consumer.navigation.graphs

import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.consumer.features.onBoarding.presintation.components.OnBoardingScreen
import com.example.consumer.navigation.routes.AuthGraphRout
import org.koin.compose.viewmodel.koinViewModel


fun NavGraphBuilder.authGraph(
    navController: NavHostController,
) {
    navigation<AuthGraphRout.AuthGraph>(
        startDestination = AuthGraphRout.OnBoardingScreen,
    ) {
        composable<AuthGraphRout.OnBoardingScreen> {
            OnBoardingScreen()
        }

    }
}
