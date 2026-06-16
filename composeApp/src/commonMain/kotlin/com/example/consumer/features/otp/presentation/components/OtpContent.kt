package com.example.consumer.features.otp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.consumer.core.presentation.components.bars.TransparentToolbar
import com.example.consumer.core.presentation.foundation.typography.H4
import com.example.consumer.core.presentation.foundation.typography.Subtitle2
import org.jetbrains.compose.resources.stringResource
import com.example.consumer.features.otp.presentation.viewModel.OtpSource
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.confirm

@Preview(name = "OTP Verification Screen", locale = "ar")
@Composable
fun OtpInputPreview() {
    ConsumerTheme {
        OtpContent(
//            state = OtpState(
//                otp = "1234",
//                isResendEnabled = true,
//                timeLeft = 0,
//                error = null,
//                isLoading = false,
//                isVerified = false
//            ),
            onOtpChange = {},
            onResendClick = {},
            onVerifyClick = {},
//            isOtpError = true,
            navController = rememberNavController(),
            clearError = {},
            source = OtpSource.FORGOT_PASSWORD,
            email = "salma@mailinator.com",
            phone = ""
        )
    }
}


@Composable
fun OtpContent(

//    state: OtpState,
    onOtpChange: (String) -> Unit,
    onResendClick: () -> Unit,
    onVerifyClick: () -> Unit,
//    isOtpError: Boolean,
    navController: NavHostController,
    clearError: () -> Unit,
    source: OtpSource = OtpSource.REGISTER,
    email: String = "",
    phone: String = ""
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    val focusManager = LocalFocusManager.current

    val density = LocalDensity.current
    val imeBottom = WindowInsets.ime.getBottom(density)

    val isKeyboardVisible = imeBottom > 0

    var handled by remember { mutableStateOf(false) }
//
//    BackHandler {
//        if (isKeyboardVisible && !handled) {
//            handled = true
//            focusManager.clearFocus()
//        } else {
//            handled = false
//            navController.popBackStack()
//        }
//    }
    val snackbarHostState = remember { SnackbarHostState() }
    val snackbarHostStateSuccess = remember { SnackbarHostState() }

//    LaunchedEffect(state.showSuccessSnackbar) {
//        if (state.showSuccessSnackbar) {
//            snackbarHostStateSuccess.showSnackbar(
//                message = "successMessage",
//                duration = SnackbarDuration.Short
//            )
//        }
//    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.imePadding().verticalScroll(rememberScrollState())) {
                TransparentToolbar(
                    navController = navController
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Text(
                        text = "أدخل رمز التحقق",
                        style = H4.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "تم إرسال رمز مكون من 4 أرقام إلى بريدك الإلكتروني",
                        style = Subtitle2.copy(fontWeight = FontWeight.Medium),
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colorScheme.extendedColors.OTPBoxBorderColor,
                    )

                    Spacer(modifier = Modifier.height(40.dp))
                    CompositionLocalProvider(
                        LocalLayoutDirection provides LayoutDirection.Ltr
                    ) {
                        OtpInput(
                            otp = "1234",
//                            isError = isOtpError,
                            onOtpChange = {
//                                onOtpChange(it)
                            },
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = "لم يصلك رمز التحقق؟",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.extendedColors.OTPBoxBorderColor,
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    ResendCodeText(
//                            state,
                        onResendClick
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
                VerifyButton(
//                    otp = state.otp,
                    otp = "",
                    onVerifyClick = {
                        onVerifyClick()
                        keyboardController?.hide()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.confirm),
                    enabled = true
//                        state.isOtpFull && !state.isLoading

                )

            }

//            // Render the snackbar host so showSnackbar actually displays something
//            ErrorSnackbar(
//                hostState = snackbarHostState,
//                modifier = Modifier.align(Alignment.BottomCenter).imePadding()
//            )
//            SnackbarHost(
//                hostState = snackbarHostStateSuccess,
//                modifier = Modifier.align(Alignment.BottomCenter).imePadding()
//            )
        }
    }
//    if (state.isLoading) {
//        LoadingOverlay()
//    }

}

