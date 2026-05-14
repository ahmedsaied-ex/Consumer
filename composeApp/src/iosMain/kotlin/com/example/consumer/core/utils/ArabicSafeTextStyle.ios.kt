package com.example.consumer.core.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

actual fun arabicSafeTextStyle(
    fontSize: TextUnit,
    color: Color,
    fontFamily: FontFamily?,
    lineHeight: TextUnit,
    textAlign: TextAlign
): TextStyle = TextStyle(
    fontSize = fontSize,
    color = color,
    fontFamily = fontFamily,
    lineHeight = lineHeight,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    ),
    textAlign = textAlign,

)
