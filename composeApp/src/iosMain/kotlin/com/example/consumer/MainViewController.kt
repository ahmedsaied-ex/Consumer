package com.example.consumer

import androidx.compose.ui.window.ComposeUIViewController
import com.example.consumer.core.di.initKoin

@Suppress("FunctionNaming")
fun MainViewController() =
    ComposeUIViewController(
        configure = {
            initKoin()
        },
    ) { App() }
