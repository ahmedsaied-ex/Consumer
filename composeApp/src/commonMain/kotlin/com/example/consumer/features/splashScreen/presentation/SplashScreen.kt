package com.example.consumer.features.splashScreen.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.lines.HorizontalLine
import com.example.consumer.core.presentation.foundation.typography.H5
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import com.example.consumer.features.splashScreen.domain.model.SplashDestination
import com.example.consumer.features.splashScreen.presentation.viewModel.SplashScreenViewModel
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.consumer_voice
import consumer.composeapp.generated.resources.splash_screen_image
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreenUi(
    modifier: Modifier = Modifier,
    viewModel: SplashScreenViewModel = koinViewModel(),
    onDestinationReady: (SplashDestination) -> Unit,
) {
    println("SplashScreen: Composable created/recomposed")
    val destination by viewModel.destination.collectAsState(initial = null)
    var visible by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        // Force refresh destination when Splash screen is shown
        println("SplashScreen: Forcing destination refresh")
        viewModel.refreshDestination()
    }

    LaunchedEffect(destination) {
        destination?.let {
            println("SplashScreen: Destination received: $it")
            delay(3000)
            visible = false
            delay(100)
            println("SplashScreen: Calling onDestinationReady with: $it")
            onDestinationReady(it)
        }
    }

    Column(
        modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painterResource(Res.drawable.splash_screen_image), contentDescription = null)
        Spacer(Modifier.height(25.dp))
        HorizontalLine(modifier = Modifier.width(206.dp))
        Spacer(Modifier.height(16.dp))
        Text(
            stringResource(Res.string.consumer_voice),
            style = H5.copy(color = MaterialTheme.colorScheme.extendedColors.blueSapphire700)
        )
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun SplashScreenUiPreview() {
    ConsumerTheme {

        SplashScreenUi(
            onDestinationReady = {  }
        )

    }
}