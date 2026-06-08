package com.example.consumer.features.otp.presentation.viewModel

import kotlinx.serialization.Serializable

@Serializable
enum class OtpSource {
    REGISTER,
    FORGOT_PASSWORD,
    LOG_IN,
    CHANGE_MOBILE_NUMBER,
    UPDATE_EMAIL,


}
