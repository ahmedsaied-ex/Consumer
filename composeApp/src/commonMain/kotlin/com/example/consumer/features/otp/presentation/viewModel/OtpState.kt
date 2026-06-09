package com.example.consumer.features.otp.presentation.viewModel

import com.example.consumer.core.presentation.utils.UiText


data class OtpState(
    val showSuccessSnackbar: Boolean = false,
    val otp: String = "",
    val timeLeft: Int = 10,
    val isResendEnabled: Boolean = false,
    val isLoading: Boolean = false,
    val error: UiText? = null,
    val inputError: Boolean = false,
    val isVerified: Boolean = false,
    val hasAttemptedVerify: Boolean = false,
    val isResendInProgress: Boolean = false,
    val success: Boolean = false,
    val isLoggedIn: Boolean = false

) {
    val isOtpFull: Boolean get() = otp.replace(" ", "").length == 4
}
