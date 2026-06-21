package com.example.consumer

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.auctionex.expertapps.navigation.utils.NavGuard
import com.example.consumer.core.data.dataStore.language.LanguageDataStore
import com.example.consumer.core.domain.dataStorage.language.AppLocaleProvider
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.features.onBoarding.presintation.components.OnBoardingScreen
import com.example.consumer.navigation.navigationHost.NavigationHost
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    NavGuard.configure()
    val navController = rememberNavController()
    val languageDataStore: LanguageDataStore = koinInject()

    AppLocaleProvider(languageDataStore) {
        ConsumerTheme {
            ConsumerBaseScreen {
                NavigationHost(navController)
            }
        }
    }
}


@Composable
fun ConsumerBaseScreen(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }
            }
    ) {
        content()
    }
}


