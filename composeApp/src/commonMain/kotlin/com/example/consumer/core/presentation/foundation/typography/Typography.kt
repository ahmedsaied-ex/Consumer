package com.example.consumer.core.presentation.foundation.typography

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val consumerTypography @Composable get() = Typography(
    displayLarge = TextStyle(  //H1
        fontFamily = IBMPlexSansArabic,
        fontSize = 62.sp,
        lineHeight = 92.sp,
    ),
    displayMedium = TextStyle(//H2
        fontFamily = IBMPlexSansArabic,
        fontSize = 48.sp,
        lineHeight = 72.sp,
    ),
    displaySmall =  TextStyle(//H3
        fontFamily = IBMPlexSansArabic,
        fontSize = 40.sp,
        lineHeight = 60.sp,
    ),
    headlineLarge = TextStyle(//H4
        fontFamily = IBMPlexSansArabic,
        fontSize = 32.sp,
        lineHeight = 44.sp,
    ),
    headlineMedium = TextStyle(//H5
        fontFamily = IBMPlexSansArabic,
        fontSize = 26.sp,
        lineHeight = 36.sp,
    ),
    headlineSmall = TextStyle(//H6
        fontFamily = IBMPlexSansArabic,
        fontSize = 20.sp,
        lineHeight = 32.sp,
    ),
    titleLarge = TextStyle(//Subtitle1
        fontFamily = IBMPlexSansArabic,
        fontSize = 18.sp,
        lineHeight = 34.sp,
    ),
    titleMedium = TextStyle(//Subtitle2
        fontFamily = IBMPlexSansArabic,
        fontSize = 16.sp,
        lineHeight = 28.sp,
    ),
    titleSmall = TextStyle(//Subtitle3
        fontFamily = IBMPlexSansArabic,
        fontSize = 14.sp,
        lineHeight = 24.sp,
    ),
    bodyLarge = TextStyle(//Body1
        fontFamily = IBMPlexSansArabic,
        fontSize = 16.sp,
        lineHeight = 32.sp,
    ),
    bodyMedium =TextStyle(//Body2
        fontFamily = IBMPlexSansArabic,
        fontSize = 14.sp,
        lineHeight = 28.sp,
    ),
    bodySmall = TextStyle(//Button 1
        fontFamily = IBMPlexSansArabic,
        fontSize = 16.sp,
        lineHeight = 42.sp,
    ),
    labelLarge =TextStyle(//Button 2
        fontFamily = IBMPlexSansArabic,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
)