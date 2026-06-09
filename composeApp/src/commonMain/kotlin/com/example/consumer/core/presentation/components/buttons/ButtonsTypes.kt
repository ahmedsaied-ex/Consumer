package com.example.consumer.core.presentation.components.buttons

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.consumer.core.presentation.theme.extendedColors

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
            disabledContainerColor = colorScheme.extendedColors.onDisablePrimaryLight,
            contentColor= colorScheme.onTertiaryContainer,
            disabledContentColor =colorScheme.extendedColors.onDisableTextTertiary
        )
        ButtonsTypes.DESTRUCTIVE -> ButtonFeatures(
            containerColor =  colorScheme.errorContainer,
            disabledContainerColor = colorScheme.errorContainer,
            contentColor = colorScheme.error,
            disabledContentColor = colorScheme.extendedColors.onDisableTextDestructive
        )
    }
}
