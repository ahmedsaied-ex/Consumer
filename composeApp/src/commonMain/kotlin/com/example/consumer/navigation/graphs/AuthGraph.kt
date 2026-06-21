package com.example.consumer.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.auctionex.expertapps.navigation.utils.navigateWithoutBack
import com.example.consumer.features.onBoarding.presintation.components.OnBoardingScreen
import com.example.consumer.navigation.routes.AuthGraphRout
import com.example.consumer.navigation.routes.MainGraphRoot


fun NavGraphBuilder.authGraph(
    navController: NavHostController,
) {
    navigation<AuthGraphRout.AuthGraph>(
        startDestination = AuthGraphRout.OnBoardingScreen,
    ) {
        composable<AuthGraphRout.OnBoardingScreen> {
            OnBoardingScreen(
                onContinue = {
                    navController.navigateWithoutBack(to = MainGraphRoot.MainGraph, popUpTo = AuthGraphRout.AuthGraph)
                }
            )
        }

    }
}
