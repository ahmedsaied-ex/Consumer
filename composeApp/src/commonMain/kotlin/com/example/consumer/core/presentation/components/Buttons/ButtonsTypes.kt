package com.example.consumer.core.presentation.components.Buttons

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.consumer.core.presentation.foundation.colors.ErrorBackground
import com.example.consumer.core.presentation.foundation.colors.ErrorDark
import com.example.consumer.core.presentation.foundation.colors.OnDisablePrimaryLight
import com.example.consumer.core.presentation.foundation.colors.OnDisableTextDestructive
import com.example.consumer.core.presentation.foundation.colors.OnDisableTextTertiary

enum class ButtonsTypes {
    PRIMARY,
    SECONDARY,
    TERTIARY,
    DESTRUCTIVE
}

data class ButtonFeatures(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
)

@Composable
fun ButtonsTypes.getFeatures(): ButtonFeatures {
    val colorScheme = MaterialTheme.colorScheme
    return when (this) {
        ButtonsTypes.PRIMARY -> ButtonFeatures(
            containerColor = colorScheme.primaryContainer,
            disabledContainerColor = colorScheme.secondaryContainer,
            contentColor = colorScheme.onSecondary,
            disabledContentColor = colorScheme.onSecondary
        )
        ButtonsTypes.SECONDARY -> ButtonFeatures(
            containerColor = colorScheme.secondary,
            disabledContainerColor = colorScheme.secondaryContainer,
            contentColor = colorScheme.primaryContainer,
            disabledContentColor = colorScheme.onSecondaryContainer
        )
        ButtonsTypes.TERTIARY -> ButtonFeatures(
            containerColor = colorScheme.onPrimary,
            disabledContainerColor = OnDisablePrimaryLight,
            contentColor= colorScheme.onTertiaryContainer,
            disabledContentColor = OnDisableTextTertiary
        )
        ButtonsTypes.DESTRUCTIVE -> ButtonFeatures(
            containerColor = ErrorBackground,
            disabledContainerColor = ErrorBackground,
            contentColor = ErrorDark,
            disabledContentColor = OnDisableTextDestructive
        )
    }
}
