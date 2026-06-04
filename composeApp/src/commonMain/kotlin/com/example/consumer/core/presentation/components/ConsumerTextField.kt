package com.example.consumer.core.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.theme.ConsumerTheme

@Composable
fun ConsumerTextField(
    modifier: Modifier = Modifier,
    initialValue: String = "",
    enabled: Boolean = true,
    isError: Boolean = false,
    labelText: String? = null,
    placeholderText: String? = null,
) {
    val state = rememberTextFieldState(initialValue)
    TextField(
        enabled = enabled,
        isError = isError,
        state = state,
        placeholder = placeholderText?.let {
            {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        },
        label = labelText?.let {
            {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        },
        textStyle = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Normal,
            color = if (enabled) MaterialTheme.colorScheme.onBackground else Color(0xFFB0B0BE)
        ),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedContainerColor = Color(0xFFEFEFF2),
            unfocusedContainerColor = Color(0xFFEFEFF2),
            disabledContainerColor = Color(0xFFEFEFF2),
            errorContainerColor = Color(0xFFEFEFF2),
            errorCursorColor = MaterialTheme.colorScheme.primary,
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = if (state.text.isNotBlank()) Color(0xFF6B6D85) else Color(
                0xFF999AAB
            ),
            errorSupportingTextColor = Color(0xFFDC3545),
            errorLabelColor = MaterialTheme.colorScheme.error,
            errorIndicatorColor = MaterialTheme.colorScheme.error,
            errorLeadingIconColor = MaterialTheme.colorScheme.error,
            errorTrailingIconColor = MaterialTheme.colorScheme.error,
            errorPlaceholderColor = MaterialTheme.colorScheme.error,
            disabledIndicatorColor = if (state.text.isNotBlank()) Color(0xFF6B6D85) else Color(
                0xFFB0B0BE
            ),
            disabledLabelColor = Color(0xFFB0B0BE),
            disabledLeadingIconColor = Color(0xFFB0B0BE),
            disabledPlaceholderColor = Color(0xFFB0B0BE),
            disabledTrailingIconColor = Color(0xFFB0B0BE),
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            disabledTextColor = Color(0xFFB0B0BE),
            unfocusedLabelColor = Color(0xFF6B6D85),
            focusedPlaceholderColor = Color(0xFF6B6D85),
            unfocusedPlaceholderColor = Color(0xFF6B6D85),
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun ConsumerTextFieldPreviewColoumn() {
    ConsumerTheme {
        Column(
            verticalArrangement = spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {

            Text("Unfocused")

            ConsumerTextField(
                placeholderText = "Placeholder",
//                labelText = "Empty"
            )

            ConsumerTextField(
                initialValue = "Ahmed",
                labelText = "Filled"
            )

            Text("Error")

            ConsumerTextField(
                initialValue = "Ahmed",
                isError = true,
                labelText = "Error"
            )

            Text("Disabled filled")

            ConsumerTextField(
                initialValue = "Ahmed",
                enabled = false,
                labelText = "Disabled"
            )
            Text("Disabled empty")

            ConsumerTextField(
                initialValue = "",
                enabled = false,
                labelText = "Disabled"
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ConsumerTextFieldPreview() {
    ConsumerTheme {
        Column(modifier = Modifier.padding(16.dp)) { ConsumerTextField() }
    }

}