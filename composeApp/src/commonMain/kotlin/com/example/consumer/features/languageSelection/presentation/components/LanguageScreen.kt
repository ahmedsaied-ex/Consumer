package com.example.consumer.features.languageSelection.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.data.AppLang
import com.example.consumer.core.presentation.components.CostumeScaffold
import com.example.consumer.core.presentation.components.buttons.ConsumerFilledButton
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle2
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import com.example.consumer.features.languageSelection.presentation.viewModel.LanguageViewModel
import consumer.composeapp.generated.resources.Continue
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.modify_language
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Suppress("SuspiciousIndentation")
@Composable
fun LanguageScreen(
    onContinue: () -> Unit = {},
    viewModel: LanguageViewModel = koinViewModel()

) {
    val selectedLanguage by viewModel.selectedLanguage.collectAsState()
    LanguageScreenBody(
        selectedLanguage = selectedLanguage,
        onLanguageSelected = {
            viewModel.onLanguageSelected(it)
        },
        onContinue = {
            viewModel.onContinue(onContinue)
        }
    )

}


@Composable
fun LanguageScreenBody(
    modifier: Modifier = Modifier,
    selectedLanguage: AppLang,
    onLanguageSelected: (AppLang) -> Unit,
    onContinue: () -> Unit = {},
) {
    CostumeScaffold {

        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppTitle()

                Spacer(
                    modifier = Modifier
                        .height(32.dp)
                )

                LanguageCard(
                    selectedLanguage = selectedLanguage,
                    onLanguageSelected = {
                        onLanguageSelected(it)
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    stringResource(Res.string.modify_language),
                    color = MaterialTheme.colorScheme.extendedColors.OTPBoxBorderColor,
                    textAlign = TextAlign.Center,
                    style = Subtitle2,
                )
            }


        ConsumerFilledButton(
            text = stringResource(Res.string.Continue),
            onClick = {
                onContinue()
            },
            backgroundColor = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).padding(bottom = 10.dp),
        )
        }
    }
}


@Composable
@Preview(showBackground = true, locale = "ar")
fun LanguageScreenBodyPreview() {
    ConsumerTheme {
        LanguageScreenBody(
            selectedLanguage = AppLang.ARABIC,
            onLanguageSelected = {}
        )

    }
}



