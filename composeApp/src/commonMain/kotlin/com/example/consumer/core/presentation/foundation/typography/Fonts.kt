package com.example.consumer.core.presentation.foundation.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import consumer.composeapp.generated.resources.IBMPlexSansArabic_Bold
import consumer.composeapp.generated.resources.IBMPlexSansArabic_ExtraLight
import consumer.composeapp.generated.resources.IBMPlexSansArabic_Light
import consumer.composeapp.generated.resources.IBMPlexSansArabic_Medium
import consumer.composeapp.generated.resources.IBMPlexSansArabic_Regular
import consumer.composeapp.generated.resources.IBMPlexSansArabic_SemiBold
import consumer.composeapp.generated.resources.IBMPlexSansArabic_Thin
import consumer.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

val IBMPlexSansArabic  @Composable get() = FontFamily(
    Font(
        resource = Res.font.IBMPlexSansArabic_Light,
        weight = FontWeight.Light
    ),
     Font(
        resource = Res.font.IBMPlexSansArabic_Bold,
        weight = FontWeight.Bold
    ),
     Font(
        resource = Res.font.IBMPlexSansArabic_Thin,
        weight = FontWeight.Thin
    ),
     Font(
        resource = Res.font.IBMPlexSansArabic_Medium,
        weight = FontWeight.Medium
    ),
     Font(
        resource = Res.font.IBMPlexSansArabic_SemiBold,
        weight = FontWeight.SemiBold
    ),
     Font(
        resource = Res.font.IBMPlexSansArabic_ExtraLight,
        weight = FontWeight.ExtraLight
    ),
    Font(
        resource = Res.font.IBMPlexSansArabic_Regular,
        weight = FontWeight.Normal
    ),

)
