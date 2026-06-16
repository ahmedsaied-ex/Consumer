package com.example.consumer

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.features.completeProfile.presentation.view.CompleteProfileScreen

@Composable
@Preview
fun App() {
    ConsumerTheme {
        CompleteProfileScreen()
    }
}



