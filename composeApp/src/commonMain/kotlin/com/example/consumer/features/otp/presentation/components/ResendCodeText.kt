package com.auctionex.expertapps.features.auth_feature.otp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.colors.OTPBoxBorderColor
import com.example.consumer.core.presentation.foundation.typography.Button2
import com.example.consumer.core.presentation.foundation.typography.Subtitle2

@Composable
fun ResendCodeText(
//    state: OtpState,
    onResendClick: () -> Unit
) {
//    val resendEnabled = state.isResendEnabled && !state.isResendInProgress
    val resendEnabled = true

    Row {
        Text(
//            text = stringResource(Res.string.resend_code),
            text = "إعادة إرسال",
            style = Button2.copy(fontWeight = FontWeight.Medium),
//            color = if (state.isResendEnabled) {
                color = if (true) {
                MaterialTheme.colorScheme.primaryContainer
            } else {

                MaterialTheme.colorScheme.secondaryContainer
            },
            modifier = Modifier.clickable(
                enabled =resendEnabled,
                onClick = onResendClick
            )
        )

        if (true
//            !state.isResendEnabled && state.timeLeft > 0
            ) {
            Spacer(modifier = Modifier.width(5.dp))
            Text(
//                text = "(00:${state.timeLeft.toString().padStart(2, '0')})",
                text = "(00:05)",
                style = Subtitle2.copy(fontWeight = FontWeight.Medium),
                color = OTPBoxBorderColor,
            )
        }
    }
}
