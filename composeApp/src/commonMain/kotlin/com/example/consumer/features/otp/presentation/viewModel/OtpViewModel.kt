//package com.example.consumer.features.presentation.viewModel
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Job
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import kotlin.time.Clock
//import kotlin.time.ExperimentalTime
//
//class OtpViewModel(
//    private val loginUseCase: LoginUseCase,
//    private val sessionStorage: SessionStorage,
//    private val phoneUseCase: SendOtpToUpdatePhoneUseCase,
//    private val logOutUseCase: LogOutUseCase,
//    private val updateEmailUseCase: UpdateEmailUseCase,
//    private val updateUserPhoneUseCase: UserUpdatePhoneUseCase,
//    private val errorMapper: PasswordErrorMapper,
//    private val verifyOtpUseCase: VerifyOtpUseCaseImpl,
//    private val resendOtpUseCase: ResendOtpUseCaseImpl,
//    private val changeEmailOtpUseCase: ChangeEmailOtpUseCase,
//    otpSource: OtpSource,
//    private val email: String,
//) : ViewModel() {
//
//    val uiModel: OtpUiModel = otpSource.toUiModel()
//
//    var state by mutableStateOf(OtpState())
//        private set
//
//    private var timerJob: Job? = null
//    private val otpDurationMillis = 60_000L
//    private var otpEndTime: Long = 0L
//
//    @OptIn(ExperimentalTime::class)
//    private fun nowMillis(): Long =
//        Clock.System.now().toEpochMilliseconds()
//
//    init {
//        startTimer()
//    }
//
//    fun onOtpChange(otpInput: String) {
//        state = state.copy(
//            otp = otpInput,
//            error = null,
//            inputError = false,
//            hasAttemptedVerify = false
//        )
//
//    }
//
//    private fun changeEmailOtp(request: ChangeEmailOTPRequest) {
//        state = state.copy(isLoading = true)
//        viewModelScope.launch {
//            when (val result = changeEmailOtpUseCase(request)) {
//                is Result.Success -> {
//                    state = state.copy(
//                        isLoading = false,
//                        success = true,
//                        hasAttemptedVerify = true,
//                        inputError = false,
//                        error = null
//                    )
//                    logOutUseCase.logOut()
//                }
//
//                is Result.Error -> {
//                    state = state.copy(
//                        isLoading = false,
//                        hasAttemptedVerify = true,
//                        inputError = true,
//                        error = errorMapper.mapError(result.error)
//                    )
//                }
//            }
//        }
//    }
//
//    private fun verifyOtp(request: VerifyOtpRequest) {
//        state = state.copy(isLoading = true, error = null)
//        viewModelScope.launch {
//            val result = verifyOtpUseCase(request)
//            state = when (result) {
//                is Result.Success -> {
//                    state.copy(
//                        isLoading = false,
//                        isVerified = true,
//                        hasAttemptedVerify = true,
//                        inputError = false,
//                        error = null,
//                        showSuccessSnackbar = true
//
//                    )
//                }
//
//                is Result.Error -> {
//                    state.copy(
//                        isLoading = false,
//                        hasAttemptedVerify = true,
//                        inputError = true,
//                        error = errorMapper.mapError(result.error)
//                    )
//                }
//            }
//        }
//    }
//    fun dismissSnackbar() {
//        state = state.copy(showSuccessSnackbar = false)
//    }
//    private fun verifyPhoneOtp(request: UpdatePhoneRequestBody) {
//        state = state.copy(isLoading = true, error = null)
//        viewModelScope.launch {
//            updateUserPhoneUseCase.updatePhone(request)
//                .onSuccess {
//                    state = state.copy(
//                        isLoading = false,
//                        isVerified = true,
//                        success = true,
//                        hasAttemptedVerify = true,
//                        inputError = false,
//                        error = null
//                    )
//                    logOutUseCase.logOut()
//                }
//                .onError { error ->
//                    state = state.copy(
//                        isLoading = false,
//                        hasAttemptedVerify = true,
//                        inputError = true,
//                        error = errorMapper.mapError(error)
//                    )
//                }
//        }
//    }
//
//    fun clearSuccessAndLogout() {
//        state = state.copy(success = false)
//        viewModelScope.launch { logOutUseCase.logOut() }
//    }
//
//    fun startTimer() {
//        timerJob?.cancel()
//        otpEndTime = nowMillis() + otpDurationMillis
//        timerJob = viewModelScope.launch {
//            while (true) {
//                val remaining = ((otpEndTime - nowMillis()) / 1000).toInt()
//                if (remaining <= 0) {
//                    state = state.copy(timeLeft = 0, isResendEnabled = true)
//                    break
//                }
//                state = state.copy(
//                    timeLeft = remaining,
//                    isResendEnabled = false
//                )
//                delay(1000)
//            }
//        }
//    }
//
//    fun onResendClick(source: OtpSource, phoneBody: PhoneOtpSentRequestBody) {
//        if (state.isResendInProgress || !state.isResendEnabled) return
//
//        state = state.copy(
//            isResendInProgress = true,
//            isResendEnabled = false,
//            error = null
//        )
//
//        viewModelScope.launch {
//            val result = when (source) {
//                OtpSource.UPDATE_EMAIL -> updateEmailUseCase(email)
//                OtpSource.CHANGE_MOBILE_NUMBER -> phoneUseCase.sendOtpToUpdatePhone(phoneBody)
//                else -> resendOtpUseCase(email)
//            }
//
//            when (result) {
//                is Result.Success -> {
//                    state = state.copy(
//                        isResendInProgress = false,
//                        isResendEnabled = false
//                    )
//                    startTimer()
//                }
//
//                is Result.Error -> {
//                    state = state.copy(
//                        isResendInProgress = false,
//                        isResendEnabled = true,
//                        error = errorMapper.mapError(result.error)
//
//                    )
//                }
//            }
//        }
//    }
//
//    fun login(loginRequest: LoginRequest) {
//        // ✅ Guard: don't fire twice
//        if (state.isLoading || state.isLoggedIn) return
//
//        state = state.copy(isLoading = true)
//        viewModelScope.launch {
//            loginUseCase(loginRequest)
//                .onSuccess { response ->
//                    sessionStorage.set(response.data)
//                    state = state.copy(
//                        isLoading = false,
//                        isLoggedIn = true,
//                        error = null
//                    )
//                    println(response)
//                }
//                .onError { error ->
//                    state = state.copy(
//                        isLoading = false,
//                        isLoggedIn = false,
//                        error = errorMapper.mapError(error)
//                    )
//                }
//        }
//    }
//
//    fun onVerifyClick(
//        source: OtpSource,
//        phone: String,
//        phoneCode: String,
//        e16Number: String
//    ) {
//        if (!state.isOtpFull || state.isLoading) return
//        val cleanOtp = state.otp.replace(" ", "")
//        when (source) {
//            OtpSource.CHANGE_MOBILE_NUMBER -> {
//                verifyPhoneOtp(
//                    UpdatePhoneRequestBody(
//                        otp = cleanOtp,
//                        phone = phone,
//                        phone_code = phoneCode,
//                        e16_number = e16Number
//                    )
//                )
//            }
//
//            OtpSource.UPDATE_EMAIL -> {
//                changeEmailOtp(
//                    ChangeEmailOTPRequest(
//                        email = email,
//                        otp = cleanOtp
//                    )
//                )
//            }
//
//            else -> {
//                verifyOtp(
//                    VerifyOtpRequest(
//                        email = email,
//                        otp = cleanOtp
//                    )
//                )
//            }
//        }
//    }
//
//    fun clearError() {
//        state = state.copy(error = null)
//    }
//}
