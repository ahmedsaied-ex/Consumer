package com.example.consumer.core.presentation.foundation.typography

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val H1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 62.sp,
    lineHeight = 92.sp,
    fontWeight = FontWeight.Normal
)
val H2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 48.sp,
    lineHeight = 72.sp,
    fontWeight = FontWeight.Normal

)
val H3 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 40.sp,
    lineHeight = 60.sp,
    fontWeight = FontWeight.Normal

)
val H4 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 32.sp,
    lineHeight = 44.sp,
    fontWeight = FontWeight.Normal

)
val H5 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 26.sp,
    lineHeight = 36.sp,
    fontWeight = FontWeight.Normal

)
val H6 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 20.sp,
    lineHeight = 32.sp,
    fontWeight = FontWeight.Normal

)
val Subtitle1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 18.sp,
    lineHeight = 34.sp,
    fontWeight = FontWeight.Normal

)
val Subtitle2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 16.sp,
    lineHeight = 28.sp,
    fontWeight = FontWeight.Normal

)
val Subtitle3 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 14.sp,
    lineHeight = 24.sp,
    fontWeight = FontWeight.Normal

)
val Body1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    fontWeight = FontWeight.Normal

)
val Body2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 14.sp,
    lineHeight = 28.sp,
    fontWeight = FontWeight.Normal

)
val Button1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    fontWeight = FontWeight.Normal

)
val Button2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    fontWeight = FontWeight.Normal

)

val AppTypography @Composable get() = Typography(
    displayLarge = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = IBMPlexSansArabic,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
    ),
)
