package com.example.consumer.core.presentation.components.bottomSheets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.ConsumerTextField
import com.example.consumer.core.presentation.components.buttons.ButtonsTypes
import com.example.consumer.core.presentation.components.buttons.ConsumerBorderIconButton
import com.example.consumer.core.presentation.components.buttons.ConsumerFilledButton
import com.example.consumer.core.presentation.components.tabBar.TabBar
import com.example.consumer.core.presentation.components.tabBar.TabItem
import com.example.consumer.core.presentation.foundation.typography.Subtitle2
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import com.example.consumer.features.onBoarding.domain.models.AuthTabs
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ambassador
import consumer.composeapp.generated.resources.apple_logo
import consumer.composeapp.generated.resources.close_icon
import consumer.composeapp.generated.resources.consumer
import consumer.composeapp.generated.resources.email
import consumer.composeapp.generated.resources.group
import consumer.composeapp.generated.resources.password
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun AuthBottomSheet(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    onTabSelected: (TabItem) -> Unit,
    onLoginClick: () -> Unit,
    onAppleClick: () -> Unit,
    onGoogleClick: () -> Unit,
    tabs: List<TabItem>,
    selectedTabId: String = AuthTabs.CONSUMER.name
) {
    CostumeBottomSheet(
        onDismiss = onDismiss,
    ) {
        AuthBottomSheetContent(
            modifier = modifier,
            onTabSelected = onTabSelected,
            onLoginClick = onLoginClick,
            onAppleClick = onAppleClick,
            onGoogleClick = onGoogleClick,
            tabs = tabs,
            selectedTabId = selectedTabId,
            onDismiss = onDismiss
        )
    }
}


@Composable
fun AuthBottomSheetContent(
    modifier: Modifier = Modifier,
    onTabSelected: (TabItem) -> Unit,
    onLoginClick: () -> Unit,
    onAppleClick: () -> Unit,
    onGoogleClick: () -> Unit,
    tabs: List<TabItem>,
    onDismiss: () -> Unit,
    selectedTabId: String = AuthTabs.CONSUMER.name
) {
    Column(
        modifier = modifier
    ) {
        Row(modifier = Modifier.background(MaterialTheme.colorScheme.extendedColors.darkBlue650).fillMaxWidth().padding(horizontal = 20.dp)) {
            Image(
                painterResource(Res.drawable.close_icon),
                modifier = Modifier.clickable(onClick = { onDismiss() }),
                contentDescription = "close bottom sheet"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.fillMaxWidth().background(
                MaterialTheme.colorScheme.extendedColors.profileChangePhotoBackground
            ).padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            TabBar(
                tabs = tabs,
                selectedTabId = selectedTabId,
                onTabSelected = onTabSelected
            )
        }
        Spacer(modifier = Modifier.height(28.dp))
        when (selectedTabId) {
            AuthTabs.CONSUMER.name -> {
                ConsumerBodyBottomSheet(
                    onLoginClick = onLoginClick,
                    onAppleClick = onAppleClick,
                    onGoogleClick = onGoogleClick
                )
            }

            AuthTabs.AMBASSADOR.name -> {
                AmbassadorBodyBottomSheet()
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun AmbassadorBodyBottomSheet(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit = {}
) {
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()
    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConsumerTextField(
            modifier = Modifier.fillMaxWidth(),
            state = emailState,
            label = {
                Text(
                    text = stringResource(resource = Res.string.email),
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )
        Spacer(modifier = Modifier.height(10.dp))
        ConsumerTextField(
            label = {
                Text(
                    text = stringResource(resource = Res.string.password),
                )
            },

            modifier = Modifier.fillMaxWidth(),
            state = passwordState,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
        Spacer(modifier = Modifier.height(10.dp))
        ConsumerFilledButton(
            text = "تسجيل الدخول",
            type = ButtonsTypes.PRIMARY,
            enabled = true,
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
@Preview(showBackground=true , locale = "ar")
fun AmbassadorBodyBottomSheetPreview() {
    ConsumerTheme {
        AmbassadorBodyBottomSheet()
    }

}

@Composable
fun ConsumerBodyBottomSheet(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onAppleClick: () -> Unit,
    onGoogleClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConsumerFilledButton(
            text = "اكمل باستخدام البريد الإلكتروني",
            type = ButtonsTypes.PRIMARY,
            enabled = true,
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "or",
            style = Subtitle2.copy(
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.extendedColors.darkBlue650
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        ConsumerBorderIconButton(
            text = "اكمل باستخدام Google",
            onClick = onGoogleClick,
            modifier = Modifier.fillMaxWidth(),
            iconRes = Res.drawable.group
        )
        Spacer(modifier = Modifier.height(12.dp))
        ConsumerBorderIconButton(
            text = "اكمل باستخدام Apple",
            onClick = onAppleClick,
            modifier = Modifier.fillMaxWidth(),
            iconRes = Res.drawable.apple_logo
        )

    }
}

@Composable
@Preview(showBackground=true , locale = "ar")
fun ConsumerBodyBottomSheetPreview() {
    ConsumerTheme {
        ConsumerBodyBottomSheet(
            onLoginClick = { },
            onAppleClick = { },
            onGoogleClick = {}
        )
    }

}

@Composable
@Preview(showBackground = true, locale = "ar")
fun AuthBottomSheetContentPreview() {
    ConsumerTheme {
        AuthBottomSheetContent(
            onTabSelected = {},
            onLoginClick = {},
            onAppleClick = {},
            onGoogleClick = {},
            tabs = listOf(
                TabItem(
                    id = AuthTabs.CONSUMER.name, title = Res.string.consumer
                ),
                TabItem(id = AuthTabs.AMBASSADOR.name, title = Res.string.ambassador)
            ),
            selectedTabId = AuthTabs.AMBASSADOR.name,
            onDismiss = {}
        )
    }

}

@Composable
@Preview(showBackground = true, locale = "ar")
fun AuthBottomSheetPreview() {
    ConsumerTheme {
        AuthBottomSheet(
            onTabSelected = {},
            onLoginClick = {},
            onAppleClick = {},
            onGoogleClick = {},
            tabs = listOf(
                TabItem(
                    id = AuthTabs.CONSUMER.name, title = Res.string.consumer
                ),
                TabItem(id = AuthTabs.AMBASSADOR.name, title = Res.string.ambassador)
            ),
            selectedTabId = AuthTabs.CONSUMER.name
        )
    }
}
