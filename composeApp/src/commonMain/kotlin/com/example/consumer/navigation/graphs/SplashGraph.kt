package com.example.consumer.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.auctionex.expertapps.navigation.utils.navigateWithoutBack
import com.example.consumer.features.languageSelection.presentation.components.LanguageScreen
import com.example.consumer.features.splashScreen.domain.model.SplashDestination
import com.example.consumer.features.splashScreen.presentation.SplashScreenUi
import com.example.consumer.navigation.routes.AuthGraphRout
import com.example.consumer.navigation.routes.MainGraphRoot
import com.example.consumer.navigation.routes.SplashRoute


fun NavGraphBuilder.splashGraph(
    navController: NavHostController,
) {
    composable<SplashRoute.Splash> {
        println("SplashGraph: Splash composable created")
        SplashScreenUi(
            onDestinationReady = { destination ->
                println("SplashGraph: onDestinationReady called with: $destination")
                when (destination) {
                    SplashDestination.LanguageSelection -> {
                        println("SplashGraph: Navigating to LanguageSelection")
                        navController.navigateWithoutBack(
                            to = SplashRoute.LanguageSelection,
                            popUpTo = SplashRoute.Splash
                        )
                    }

                    SplashDestination.Auth -> {
                        println("SplashGraph: Navigating to Auth")
                        navController.navigateWithoutBack(
                            to = AuthGraphRout.AuthGraph,
                            popUpTo = SplashRoute.Splash
                        )
                    }

                    SplashDestination.Home -> {
                        println("SplashGraph: Navigating to Home")
                        navController.navigateWithoutBack(
                            to = MainGraphRoot.MainGraph,
                            popUpTo = SplashRoute.Splash
                        )
                    }
                }
            }
        )
    }

    composable<SplashRoute.LanguageSelection> {
        LanguageScreen(
            onContinue = {
                navController.navigateWithoutBack(
                    to = AuthGraphRout.AuthGraph, // Or OnBoarding if applicable
                    popUpTo = SplashRoute.LanguageSelection
                )
            }
        )
    }
}
