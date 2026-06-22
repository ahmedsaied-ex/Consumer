package com.example.consumer.navigation.navigationHost

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.consumer.core.presentation.components.CostumeScaffold
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.H1
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.features.profile.presentation.UserProfile
import com.example.consumer.features.profile.presentation.components.ProfileSection
import com.example.consumer.navigation.graphs.authGraph
import com.example.consumer.navigation.graphs.splashGraph
import com.example.consumer.navigation.routes.MainGraphRoot
import com.example.consumer.navigation.routes.SplashRoute


/**
 * Centralized navigation host for better organization
 * Easy to extend with new screens
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationHost(
    navController: NavHostController,
    onExitApp: () -> Unit = {},

    modifier: Modifier = Modifier,
) {
    val durationTime = 250
    NavHost(
        navController = navController,
        startDestination = SplashRoute.Splash,
        modifier = modifier,
        enterTransition = {
            fadeIn(
                animationSpec = tween(durationTime, easing = FastOutSlowInEasing)
            ) + slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(durationTime, easing = FastOutSlowInEasing)
            )
        },
        exitTransition = {
            fadeOut(
                animationSpec = tween(durationTime, easing = FastOutSlowInEasing)
            ) + slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(durationTime, easing = FastOutSlowInEasing)
            )
        },
        popEnterTransition = {
            fadeIn(
                animationSpec = tween(durationTime, easing = FastOutSlowInEasing)
            ) + slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(durationTime, easing = FastOutSlowInEasing)
            )
        },
        popExitTransition = {
            fadeOut(
                animationSpec = tween(durationTime, easing = FastOutSlowInEasing)
            ) + slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(durationTime, easing = FastOutSlowInEasing)
            )
        }

    ) {
        splashGraph(navController = navController)
        authGraph(navController = navController)
        composable<MainGraphRoot.MainGraph> {
            UserProfile()
        }
    }
}


@Composable
fun TestMainScreen(
    modifier: Modifier = Modifier
) {

    CostumeScaffold{
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
        {
            Text("MainScreen", style = H1)
        }
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun TesTmainScreenPreview() {
    ConsumerTheme {
        Column(
            Modifier.padding(DesignSystem.Padding.Padding2XL),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Padding.Padding2XL)
        ) {
            TestMainScreen()
        }
    }
}