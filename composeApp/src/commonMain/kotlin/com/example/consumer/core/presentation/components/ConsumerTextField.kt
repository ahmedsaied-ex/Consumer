package com.example.consumer.core.presentation.components

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldLabelScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors

@Composable
fun ConsumerTextField(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    state: TextFieldState,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    label:  @Composable (TextFieldLabelScope.() -> Unit)? = null
) {
    TextField(
        trailingIcon = trailingIcon,
        keyboardOptions= keyboardOptions,
        enabled = enabled,
        isError = isError,
        state = state,
        placeholder = placeholder,
        label = label,
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.extendedColors.focusedTextField,
            focusedContainerColor = MaterialTheme.colorScheme.extendedColors.darkBlue150,
            unfocusedContainerColor = MaterialTheme.colorScheme.extendedColors.darkBlue150,
            disabledContainerColor = MaterialTheme.colorScheme.extendedColors.darkBlue150,
            errorContainerColor = MaterialTheme.colorScheme.extendedColors.darkBlue150,
            errorCursorColor = MaterialTheme.colorScheme.extendedColors.focusedTextField,
            focusedIndicatorColor = MaterialTheme.colorScheme.extendedColors.focusedTextField,
            unfocusedIndicatorColor = if (state.text.isNotBlank()) MaterialTheme.colorScheme.extendedColors.darkBlue650 else Color(
                0xFF999AAB
            ),
            errorSupportingTextColor = MaterialTheme.colorScheme.error,
            errorLabelColor = MaterialTheme.colorScheme.error,
            errorIndicatorColor = MaterialTheme.colorScheme.error,
            errorLeadingIconColor = MaterialTheme.colorScheme.error,
            errorTrailingIconColor = MaterialTheme.colorScheme.error,
            errorPlaceholderColor = MaterialTheme.colorScheme.error,
            disabledIndicatorColor = if (state.text.isNotBlank()) MaterialTheme.colorScheme.extendedColors.darkBlue650
            else MaterialTheme.colorScheme.extendedColors.darkBlue450,
            disabledLabelColor = MaterialTheme.colorScheme.extendedColors.darkBlue450,
            disabledLeadingIconColor = MaterialTheme.colorScheme.extendedColors.darkBlue450,
            disabledPlaceholderColor = MaterialTheme.colorScheme.extendedColors.darkBlue450,
            disabledTrailingIconColor = MaterialTheme.colorScheme.extendedColors.darkBlue450,
            focusedLabelColor = MaterialTheme.colorScheme.extendedColors.focusedTextField,
            disabledTextColor = MaterialTheme.colorScheme.extendedColors.darkBlue450,
            unfocusedLabelColor = MaterialTheme.colorScheme.extendedColors.darkBlue650,
            focusedPlaceholderColor = MaterialTheme.colorScheme.extendedColors.darkBlue650,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.extendedColors.darkBlue650,
        )
    )
}

@Preview(showBackground = true, locale = "ar")
@Composable
private fun ConsumerTextFieldPreviewColoumn() {
    val state = rememberTextFieldState("Ahmed")
    val focusRequester = remember { FocusRequester() }
    val focusedState = rememberTextFieldState("Ahmed")

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    ConsumerTheme {
        Column(
            verticalArrangement = spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Unfocused")
            ConsumerTextField(
                state = rememberTextFieldState(""),
                label = {
                    Text(
                        text = "Empty",
                    )
                },
                placeholder = {
                    Text(
                        text = "Placeholder",
                    )
                }
            )

            ConsumerTextField(
                label = {
                    Text(
                        text = "الدولة",
//                        style = Subtitle2
                        fontWeight = FontWeight.Bold
                    )
                },
                state = state,

            )

            Text("Error")

            ConsumerTextField(
                state = state,
                label = {
                    Text(
                        text = "Ahmed",
                        fontWeight = FontWeight.Bold
                    )
                },
                isError = true,
            )

            Text("Disabled filled")

            ConsumerTextField(
                state = state,
            )
            Text("Disabled empty")

            ConsumerTextField(
                state = state,
                enabled = false
            )

            Text("Focused")
            ConsumerTextField (
                state = focusedState,
                label = { Text("Email") },
                modifier = Modifier.focusRequester(focusRequester)
            )
        }
    }
}
