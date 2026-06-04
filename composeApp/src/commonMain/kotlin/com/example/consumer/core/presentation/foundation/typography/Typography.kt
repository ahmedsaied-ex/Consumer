package com.example.consumer.core.presentation.foundation.typography

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


val H1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 62.sp,
    lineHeight = 92.sp,
)
val H2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 48.sp,
    lineHeight = 72.sp,
)
val H3 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 40.sp,
    lineHeight = 60.sp,
)
val H4 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 32.sp,
    lineHeight = 44.sp,
)
val H5 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 26.sp,
    lineHeight = 36.sp,
)
val H6 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 20.sp,
    lineHeight = 32.sp,
)
val Subtitle1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 18.sp,
    lineHeight = 34.sp,
)
val Subtitle2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 16.sp,
    lineHeight = 28.sp,
)
val Subtitle3 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 14.sp,
    lineHeight = 24.sp,
)
val Body1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 16.sp,
    lineHeight = 32.sp,
)
val Body2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 14.sp,
    lineHeight = 28.sp,
)
val Button1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 16.sp,
    lineHeight = 24.sp,
)
val Button2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 14.sp,
    lineHeight = 20.sp,
)

val consumerTypography @Composable get() = Typography(
    displayLarge = H1,
    displayMedium = H2,
    displaySmall =  H3,
    headlineLarge = H4,
    headlineMedium = H5,
    headlineSmall = H6,
    titleLarge = Subtitle1,
    titleMedium = Subtitle2,
    titleSmall = Subtitle3,
    bodyLarge = Body1,
    bodyMedium =Body2,
    bodySmall = Button1,
    labelLarge =Button2,
)

