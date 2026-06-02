package com.example.consumer.core.presentation.foundation.typography

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val Typography @Composable get() = Typography(
    displayLarge = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 62.sp,
        lineHeight = 92.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 48.sp,
        lineHeight = 72.sp,
    ),
    displaySmall =  TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 40.sp,
        lineHeight = 60.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 32.sp,
        lineHeight = 44.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 26.sp,
        lineHeight = 36.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 20.sp,
        lineHeight = 32.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 18.sp,
        lineHeight = 34.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 16.sp,
        lineHeight = 28.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 14.sp,
        lineHeight = 24.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 16.sp,
        lineHeight = 32.sp,
    ),
    bodyMedium =TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 14.sp,
        lineHeight = 28.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 16.sp,
        lineHeight = 42.sp,
    ),
    labelLarge =TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
)