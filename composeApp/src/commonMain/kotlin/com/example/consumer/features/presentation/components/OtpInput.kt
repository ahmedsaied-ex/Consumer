package com.example.consumer.features.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.DesignSystem.ConsumerDimensions
import com.example.consumer.core.presentation.foundation.colors.OTPBoxBorderColor
import com.example.consumer.core.presentation.foundation.colors.OnDisablePrimaryLight
import com.example.consumer.core.presentation.foundation.typography.H5
import com.example.consumer.core.presentation.theme.ConsumerTheme
import kotlinx.coroutines.delay

/**
 * OTP Input Component
 * 4-digit OTP input following design system
 *
 * Single hidden BasicTextField owns all input (fixes iOS long-press backspace).
 * Tapping any visible box moves the logical cursor to that position:
 *   - Tapping box 2 when only box 0 is filled → does nothing (can't skip empty slots)
 *   - Tapping box 0 when all filled → trims OTP to 0 digits so next type overwrites from start
 *   - Tapping box 1 when boxes 0+1 filled → trims to 1 digit so next type lands in box 1
 *
 * @param otp Fixed-length string of [otpLength] chars, ' ' = empty slot.
 * @param onOtpChange Callback with the same fixed-length format.
 */
@Composable
fun OtpInput(
    otp: String,
//    isError: Boolean,
    onOtpChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val otpLength = 4
    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }

    val cleanOtp = otp.replace(" ", "")
    val isComplete = cleanOtp.length == otpLength

    // activeIndex = the box that visually shows the cursor
    // It equals cleanOtp.length normally, but the user can tap a filled box to move it back
    var activeIndex by remember { mutableStateOf(0) }

    // Keep activeIndex in sync when otp changes externally (e.g. auto-fill, paste)
    LaunchedEffect(cleanOtp) {
        activeIndex = cleanOtp.length.coerceAtMost(otpLength - 1)
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        // ── Visual boxes ──────────────────────────────────────────────────────
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                12.dp,
                alignment = Alignment.CenterHorizontally
            ),
        ) {
            repeat(otpLength) { index ->
                val digitStr = cleanOtp.getOrNull(index)?.toString() ?: ""
                val showCursor = isFocused && activeIndex == index && digitStr.isEmpty()

                OtpDigitBox(
                    digit = digitStr,
//                    isError = isError,
                    isError = false,
                    isFocused = isFocused && activeIndex == index,
                    isComplete = isComplete,
                    showCursor = showCursor,
                    modifier = Modifier
//                        .weight(1f)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                        ) {
                            // Only allow tapping boxes up to the first empty slot.
                            // e.g. if cleanOtp = "12", valid taps are box 0 and box 1.
                            // Box 2 is the next empty — tapping it just moves cursor there (default).
                            // Box 3 cannot be jumped to if box 2 is empty.
                            val firstEmpty = cleanOtp.length  // index of first unfilled box
                            when {
                                index < firstEmpty -> {
                                    // Tap on a filled box → trim OTP to [index] digits
                                    // so the cursor lands just before this box.
                                    // e.g. tap box 1 with "1234" → trim to "1", cursor at box 1
                                    val trimmed = cleanOtp.take(index).padEnd(otpLength, ' ')
                                    activeIndex = index
                                    onOtpChange(trimmed)
                                    focusRequester.requestFocus()
                                }

                                index == firstEmpty -> {
                                    // Tap on the current empty box → just ensure focus
                                    activeIndex = index
                                    focusRequester.requestFocus()
                                }
                                // index > firstEmpty: skip — can't jump past empty slots
                            }
                        },
                )
            }
        }

        // ── Invisible single TextField — owns ALL keyboard input ──────────────
        BasicTextField(
            value = TextFieldValue(
                text = cleanOtp,
                selection = TextRange(cleanOtp.length),
            ),
            onValueChange = { raw ->
                val newDigits = raw.text.filter { it.isDigit() }.take(otpLength)
                val padded = newDigits.padEnd(otpLength, ' ')
                activeIndex = newDigits.length.coerceAtMost(otpLength - 1)
                onOtpChange(padded)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .matchParentSize()
                .focusRequester(focusRequester)
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                },
            cursorBrush = SolidColor(Color.Transparent),
            textStyle = MaterialTheme.typography.bodySmall.copy(color = Color.Transparent),
            decorationBox = { },
        )
    }
}

@Composable
private fun OtpDigitBox(
    digit: String,
    isError: Boolean,
    isFocused: Boolean,
    isComplete: Boolean,
    showCursor: Boolean,
    modifier: Modifier = Modifier,
) {
    val borderColor = when {
        isError -> MaterialTheme.colorScheme.error
//        isComplete -> SuccessLight
        digit.isNotEmpty() -> OTPBoxBorderColor
        isFocused -> MaterialTheme.colorScheme.tertiary
        else -> OnDisablePrimaryLight
    }
    val borderSize = when {
        isFocused -> 2.dp
        else -> 1.dp
    }

    var cursorAlpha by remember { mutableStateOf(1f) }
    if (showCursor) {
        LaunchedEffect(Unit) {
            while (true) {
                cursorAlpha = 1f
                delay(500)
                cursorAlpha = 0f
                delay(500)
            }
        }
    }

    Box(
        modifier = modifier
            .width(56.dp).height(64.dp)
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(ConsumerDimensions.radius.radiusXl),
            )
            .border(
                width = borderSize,
                color = borderColor,
                shape = RoundedCornerShape(ConsumerDimensions.radius.radiusXl),
            ),
        contentAlignment = Alignment.Center,
    ) {
        if (showCursor) {
            Box(
                modifier = Modifier
                    .size(width = 2.dp, height = 24.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiary.copy(alpha = cursorAlpha),
                    ),
            )
        } else {
            Text(
                text = digit,
                style = H5.copy(
                    textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                ),
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun OtpInputsPreviewPreview() {
    ConsumerTheme {
        OtpInput(
            otp = "34",
            onOtpChange = { },
            modifier = Modifier.fillMaxWidth(),
        )
    }

}