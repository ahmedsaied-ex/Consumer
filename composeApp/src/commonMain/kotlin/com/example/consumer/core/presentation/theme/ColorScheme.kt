package com.example.consumer.core.presentation.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.example.consumer.core.presentation.foundation.colors.BackgroundDark
import com.example.consumer.core.presentation.foundation.colors.BackgroundLight
import com.example.consumer.core.presentation.foundation.colors.ErrorContainerDark
import com.example.consumer.core.presentation.foundation.colors.ErrorContainerLight
import com.example.consumer.core.presentation.foundation.colors.ErrorDark
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


val LocalExtendedColors = staticCompositionLocalOf { extendedColors }
val ColorScheme.extendedColors: ExtendedColors
    @ReadOnlyComposable
    @Composable
    get() = LocalExtendedColors.current

@Immutable
data class ExtendedColors(
    val newMissionTextColor: Color,
    val newMissionBackgroundColor: Color,

    val inProgressMissionTextColor: Color,
    val inProgressMissionBackgroundColor: Color,

    val underReviewMissionTextColor: Color,
    val underReviewMissionBackgroundColor: Color,

    val reevaluateMissionTextColor: Color,
    val reevaluateMissionBackgroundColor: Color,


    val completedMissionTextColor: Color,
    val completedMissionBackgroundColor: Color,

    // circles
    val unAssignedCircleColor: Color,
    val inProgressCircleColor: Color,
    val completedCircleColor: Color,
    val reevaluateCircleColor: Color,
    val newCircleColor: Color,

    //tabBar
    val tabBarColorTabsBackground: Color,
    val tabUnselectedBackgroundColor: Color,

    // profile 
    val profileChangePhotoBackground: Color,
    val profileSectionEvenItemBackgroundColor: Color,
    val profileSectionOddItemBackgroundColor: Color,

    // other colors
    val darkBlue650: Color,
    val darkBlue450: Color,
    val darkBlue150: Color,
    val darkBlue100: Color,
    val cadetBlue: Color,



    // tex field
    val focusedTextField : Color,

    val onDisablePrimaryLight : Color,
    val onDisableTextTertiary  : Color,
    val onDisableTextDestructive   : Color,
    val buttonBorderColorAuth  : Color,
)

val extendedColors = ExtendedColors(
    newMissionTextColor = Color(0xFF1B6397),
    newMissionBackgroundColor = Color(0xFFEAF6FF),

    inProgressMissionTextColor = Color(0xFF8E7700),
    inProgressMissionBackgroundColor = Color(0xFFFAF7E5),

    underReviewMissionTextColor = Color(0xFF2F8B8B),
    underReviewMissionBackgroundColor = Color(0xFFEDFBFB),

    completedMissionTextColor = Color(0xFF2E7D32),
    completedMissionBackgroundColor = Color(0xFFECF5EC),

    reevaluateMissionTextColor = Color(0xFFC00097),
    reevaluateMissionBackgroundColor = Color(0xFFFFDEF8),

    //circles
    unAssignedCircleColor = Color(0xFFC6C7D0),
    inProgressCircleColor = Color(0xFFEFC900),
    completedCircleColor = Color(0xFF2E7D32),
    reevaluateCircleColor = Color(0xFFC00097),
    newCircleColor = Color(0xFF1B6397),

    //tabBar
    tabBarColorTabsBackground = Color(0xFFE9EFF2),
    tabUnselectedBackgroundColor = Color(0xFFE8E9EC),
    profileChangePhotoBackground = Color(0xFFC8D6DF),


    //profile
    profileSectionEvenItemBackgroundColor = Color(0xFFF4F7F9),
    profileSectionOddItemBackgroundColor = Color(0xFFFBFCFC),


    // other colors
    darkBlue650 = Color(0xFF6B6D85),
    darkBlue450 = Color(0xFFB0B0BE),
    darkBlue150 = Color(0xFFEFEFF2),
    darkBlue100 = Color(0xFFF4F4F6),
    cadetBlue = Color(0xFF83C0C0),

    // text field
    focusedTextField = Color(0xFF377373),

    onDisablePrimaryLight = Color(0xFFDDDDE3),
    onDisableTextTertiary = Color(0xFF8E8FA2),
    onDisableTextDestructive = Color(0xFFEE9AA2),
    buttonBorderColorAuth = Color(0xFFE8E9EC),
)

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
        error = ErrorDark,
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


