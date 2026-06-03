package com.example.consumer.core.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.consumer.core.presentation.foundation.colors.BackgroundDark
import com.example.consumer.core.presentation.foundation.colors.BackgroundLight
import com.example.consumer.core.presentation.foundation.colors.ErrorContainerDark
import com.example.consumer.core.presentation.foundation.colors.ErrorContainerLight
import com.example.consumer.core.presentation.foundation.colors.ErrorDark
import com.example.consumer.core.presentation.foundation.colors.ErrorLight
import com.example.consumer.core.presentation.foundation.colors.InverseOnSurfaceDark
import com.example.consumer.core.presentation.foundation.colors.InverseOnSurfaceLight
import com.example.consumer.core.presentation.foundation.colors.InversePrimaryDark
import com.example.consumer.core.presentation.foundation.colors.InversePrimaryLight
import com.example.consumer.core.presentation.foundation.colors.InverseSurfaceDark
import com.example.consumer.core.presentation.foundation.colors.InverseSurfaceLight
import com.example.consumer.core.presentation.foundation.colors.OnBackgroundDark
import com.example.consumer.core.presentation.foundation.colors.OnBackgroundLight
import com.example.consumer.core.presentation.foundation.colors.OnErrorContainerDark
import com.example.consumer.core.presentation.foundation.colors.OnErrorContainerLight
import com.example.consumer.core.presentation.foundation.colors.OnErrorDark
import com.example.consumer.core.presentation.foundation.colors.OnErrorLight
import com.example.consumer.core.presentation.foundation.colors.OnPrimaryContainerDark
import com.example.consumer.core.presentation.foundation.colors.OnPrimaryContainerLight
import com.example.consumer.core.presentation.foundation.colors.OnPrimaryDark
import com.example.consumer.core.presentation.foundation.colors.OnPrimaryLight
import com.example.consumer.core.presentation.foundation.colors.OnSecondaryContainerDark
import com.example.consumer.core.presentation.foundation.colors.OnSecondaryContainerLight
import com.example.consumer.core.presentation.foundation.colors.OnSecondaryDark
import com.example.consumer.core.presentation.foundation.colors.OnSecondaryLight
import com.example.consumer.core.presentation.foundation.colors.OnSurfaceDark
import com.example.consumer.core.presentation.foundation.colors.OnSurfaceLight
import com.example.consumer.core.presentation.foundation.colors.OnSurfaceVariantDark
import com.example.consumer.core.presentation.foundation.colors.OnSurfaceVariantLight
import com.example.consumer.core.presentation.foundation.colors.OnTertiaryContainerDark
import com.example.consumer.core.presentation.foundation.colors.OnTertiaryContainerLight
import com.example.consumer.core.presentation.foundation.colors.OnTertiaryDark
import com.example.consumer.core.presentation.foundation.colors.OnTertiaryLight
import com.example.consumer.core.presentation.foundation.colors.OutlineDark
import com.example.consumer.core.presentation.foundation.colors.OutlineLight
import com.example.consumer.core.presentation.foundation.colors.OutlineVariantLight
import com.example.consumer.core.presentation.foundation.colors.PrimaryContainerDark
import com.example.consumer.core.presentation.foundation.colors.PrimaryContainerLight
import com.example.consumer.core.presentation.foundation.colors.PrimaryDark
import com.example.consumer.core.presentation.foundation.colors.PrimaryLight
import com.example.consumer.core.presentation.foundation.colors.ScrimDark
import com.example.consumer.core.presentation.foundation.colors.ScrimLight
import com.example.consumer.core.presentation.foundation.colors.SecondaryContainerDark
import com.example.consumer.core.presentation.foundation.colors.SecondaryContainerLight
import com.example.consumer.core.presentation.foundation.colors.SecondaryDark
import com.example.consumer.core.presentation.foundation.colors.SecondaryLight
import com.example.consumer.core.presentation.foundation.colors.SurfaceBrightDark
import com.example.consumer.core.presentation.foundation.colors.SurfaceBrightLight
import com.example.consumer.core.presentation.foundation.colors.SurfaceContainerDark
import com.example.consumer.core.presentation.foundation.colors.SurfaceContainerHighDark
import com.example.consumer.core.presentation.foundation.colors.SurfaceContainerHighLight
import com.example.consumer.core.presentation.foundation.colors.SurfaceContainerHighestDark
import com.example.consumer.core.presentation.foundation.colors.SurfaceContainerHighestLight
import com.example.consumer.core.presentation.foundation.colors.SurfaceContainerLight
import com.example.consumer.core.presentation.foundation.colors.SurfaceContainerLowDark
import com.example.consumer.core.presentation.foundation.colors.SurfaceContainerLowLight
import com.example.consumer.core.presentation.foundation.colors.SurfaceContainerLowestDark
import com.example.consumer.core.presentation.foundation.colors.SurfaceContainerLowestLight
import com.example.consumer.core.presentation.foundation.colors.SurfaceDark
import com.example.consumer.core.presentation.foundation.colors.SurfaceDimDark
import com.example.consumer.core.presentation.foundation.colors.SurfaceDimLight
import com.example.consumer.core.presentation.foundation.colors.SurfaceLight
import com.example.consumer.core.presentation.foundation.colors.SurfaceVariantDark
import com.example.consumer.core.presentation.foundation.colors.SurfaceVariantLight
import com.example.consumer.core.presentation.foundation.colors.TertiaryContainerDark
import com.example.consumer.core.presentation.foundation.colors.TertiaryContainerLight
import com.example.consumer.core.presentation.foundation.colors.TertiaryDark
import com.example.consumer.core.presentation.foundation.colors.TertiaryLight
import com.example.consumer.core.presentation.foundation.typography.consumerTypography


// Brand color schemes
internal val LightColorScheme =
    lightColorScheme(
        primary = PrimaryLight,
        onPrimary = OnPrimaryLight,
        primaryContainer = PrimaryContainerLight,
        onPrimaryContainer = OnPrimaryContainerLight,
        secondary = SecondaryLight,
        onSecondary = OnSecondaryLight,
        secondaryContainer = SecondaryContainerLight,
        onSecondaryContainer = OnSecondaryContainerLight,
        tertiary = TertiaryLight,
        onTertiary = OnTertiaryLight,
        tertiaryContainer = TertiaryContainerLight,
        onTertiaryContainer = OnTertiaryContainerLight,
        error = ErrorLight,
        onError = OnErrorLight,
        errorContainer = ErrorContainerLight,
        onErrorContainer = OnErrorContainerLight,
        background = BackgroundLight,
        onBackground = OnBackgroundLight,
        surface = SurfaceLight,
        onSurface = OnSurfaceLight,
        surfaceVariant = SurfaceVariantLight,
        onSurfaceVariant = OnSurfaceVariantLight,
        outline = OutlineLight,
        outlineVariant = OutlineVariantLight,
        scrim = ScrimLight,
        inverseSurface = InverseSurfaceLight,
        inverseOnSurface = InverseOnSurfaceLight,
        inversePrimary = InversePrimaryLight,
        surfaceDim = SurfaceDimLight,
        surfaceBright = SurfaceBrightLight,
        surfaceContainerLowest = SurfaceContainerLowestLight,
        surfaceContainerLow = SurfaceContainerLowLight,
        surfaceContainer = SurfaceContainerLight,
        surfaceContainerHigh = SurfaceContainerHighLight,
        surfaceContainerHighest = SurfaceContainerHighestLight,

        )

internal val DarkColorScheme =
    darkColorScheme(
        primary = PrimaryDark,
        onPrimary = OnPrimaryDark,
        primaryContainer = PrimaryContainerDark,
        onPrimaryContainer = OnPrimaryContainerDark,
        secondary = SecondaryDark,
        onSecondary = OnSecondaryDark,
        secondaryContainer = SecondaryContainerDark,
        onSecondaryContainer = OnSecondaryContainerDark,
        tertiary = TertiaryDark,
        onTertiary = OnTertiaryDark,
        tertiaryContainer = TertiaryContainerDark,
        onTertiaryContainer = OnTertiaryContainerDark,
        error = ErrorDark,
        onError = OnErrorDark,
        errorContainer = ErrorContainerDark,
        onErrorContainer = OnErrorContainerDark,
        background = BackgroundDark,
        onBackground = OnBackgroundDark,
        surface = SurfaceDark,
        onSurface = OnSurfaceDark,
        surfaceVariant = SurfaceVariantDark,
        onSurfaceVariant = OnSurfaceVariantDark,
        outline = OutlineDark,
        outlineVariant = OutlineVariantLight,
        scrim = ScrimDark,
        inverseSurface = InverseSurfaceDark,
        inverseOnSurface = InverseOnSurfaceDark,
        inversePrimary = InversePrimaryDark,
        surfaceDim = SurfaceDimDark,
        surfaceBright = SurfaceBrightDark,
        surfaceContainerLowest = SurfaceContainerLowestDark,
        surfaceContainerLow = SurfaceContainerLowDark,
        surfaceContainer = SurfaceContainerDark,
        surfaceContainerHigh = SurfaceContainerHighDark,
        surfaceContainerHighest = SurfaceContainerHighestDark,
    )



@Composable
fun ConsumerTheme(content: @Composable () -> Unit){
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = consumerTypography,
    ){
        content()
    }
}

