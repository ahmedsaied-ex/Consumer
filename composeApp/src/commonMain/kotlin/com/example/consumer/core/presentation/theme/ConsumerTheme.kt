package com.example.consumer.core.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.consumer.core.presentation.foundation.typography.AppTypography


@Composable
fun ConsumerTheme(content: @Composable () -> Unit){
    val extendedColors = extendedColors

    CompositionLocalProvider(LocalExtendedColors     provides extendedColors){
        MaterialTheme(
            colorScheme = LightColorScheme,
            typography = AppTypography,
        ) {
            content()
        }
    }
}

