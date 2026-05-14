package com.example.consumer.core.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

expect fun arabicSafeTextStyle(
    fontSize: TextUnit,
    color: Color,
    fontFamily: FontFamily?,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign = TextAlign.Start
): TextStyle
