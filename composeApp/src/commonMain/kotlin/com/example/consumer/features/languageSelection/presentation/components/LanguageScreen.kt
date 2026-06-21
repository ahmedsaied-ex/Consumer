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
import com.example.consumer.core.presentation.components.buttons.ConsumerFilledButton
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import com.example.consumer.features.languageSelection.presentation.viewModel.LanguageViewModel
import consumer.composeapp.generated.resources.Continue
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.modify_language
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Preview(showBackground = true)
@Suppress("SuspiciousIndentation")
@Composable
fun LanguageScreen(
    onContinue: () -> Unit = {},
    viewModel: LanguageViewModel = koinViewModel()

) {
    val selectedLanguage by viewModel.selectedLanguage.collectAsState()

    ConsumerTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    White

                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(1f))

                AppTitle()

                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                )

                LanguageCard(
                    selectedLanguage = selectedLanguage,
                    onLanguageSelected = {
                            viewModel.onLanguageSelected(it)
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    stringResource(Res.string.modify_language),
                    color = MaterialTheme.colorScheme.extendedColors.OTPBoxBorderColor,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 20.dp)

                )
                Spacer(modifier = Modifier.weight(1f))

                ConsumerFilledButton(
                    text = stringResource(Res.string.Continue),
                    onClick = {
                            viewModel.onContinue(onContinue)
                    },
                    backgroundColor = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }


    }
}