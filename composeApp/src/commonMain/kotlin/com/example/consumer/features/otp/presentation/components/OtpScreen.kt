package com.example.consumer.features.otp.presentation.components

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.auctionex.expertapps.features.auth_feature.otp.presentation.components.OtpContent
import com.example.consumer.features.otp.presentation.viewModel.OtpSource


@Composable
fun OtpScreen(
//    sharedViewModel: OTPAndLoginSharedViewModel=koinViewModel(),
    email: String,
    navController: NavHostController,
    source: OtpSource,
    phone: String,
    phoneCode: String,
    e16Number: String,
//    viewModel: OtpViewModel = koinViewModel { parametersOf(email, source) }

) {

//    val state = viewModel.state
//    val isOtpError = state.inputError && state.hasAttemptedVerify

//    LaunchedEffect(state.isVerified) {
//        if (state.isVerified) {
//            when (source) {
//                OtpSource.REGISTER -> {
//                    delay(1000)
//                    navController.navigateAndClearStack(
//                        to = AuthGraphRout.LoginScreenRout,
//                        popUpTo = AuthGraphRout.RegisterScreenRout
//                    )
//                }
//                OtpSource.FORGOT_PASSWORD -> {
//                    navController.navigateSafe(
//                        AuthGraphRout.CreateNewPasswordScreen(email, state.otp.replace(" ", "")
//                        )
//                    ) {
//                        popUpTo(AuthGraphRout.ForgotPasswordScreen) {
//                            inclusive = false
//                        }
//                        launchSingleTop = true
//                    }
//                }
//                OtpSource.LOG_IN -> {
//                    val loginRequest = sharedViewModel.getOtpAndLoginRequest()
//                    viewModel.login(loginRequest)
//                }
//                OtpSource.UPDATE_EMAIL -> {  }
//                OtpSource.CHANGE_MOBILE_NUMBER -> {  }
//            }
//        }
//    }

//    LaunchedEffect(state.isLoggedIn) {
//        if (state.isLoggedIn) {
////            navController.navigateWithoutBack(
////                to = MainGraphRoot.MainGraph,
////                popUpTo = AuthGraphRout.AuthGraph
////            )
//        }
//    }
    Scaffold{
//        AppScaffold{
        OtpContent(
//            isOtpError = isOtpError,
//            state = state,
            onOtpChange = {
//                viewModel.onOtpChange(it)
//                println("OTP = $it")
            },
            onResendClick = {
//                    viewModel.onResendClick(
//                        source, phoneBody = PhoneOtpSentRequestBody(
//                            phone = phone,
//                            phone_code = phoneCode
//                        )
//                    )
            },
            navController = navController,
            onVerifyClick = {
//                viewModel.onVerifyClick(
//                    source = source,
//                    phone = phone,
//                    phoneCode = phoneCode,
//                    e16Number = e16Number
//                )
            },
            clearError = {
//                viewModel.clearError()
                         },
//                uiModel = viewModel.uiModel,
            source = source,
            email = email,
            phone = phone
        )
        }
        }

//    if (state.success && source == OtpSource.UPDATE_EMAIL) {
//        SuccessDialog(
//            message = stringResource(Res.string.new_email_changed_successfully),
//            onSuccess = {
//                viewModel.clearSuccessAndLogout()
//                navController.navigateSafe(AuthGraphRout.LoginScreenRout) {
//                    popUpTo(0) { inclusive = true }
//                    launchSingleTop = true
//                }
//            }
//        )
//    } else if (state.success && source == OtpSource.CHANGE_MOBILE_NUMBER) {
//        SuccessDialog(
//            onSuccess = {
//                viewModel.clearSuccessAndLogout()
//                navController.navigateSafe(AuthGraphRout.LoginScreenRout) {
//                    popUpTo(0) { inclusive = true }
//                    launchSingleTop = true
//                }
//            }
//        )
//    }
//}
