package com.example.consumer.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.theme.ConsumerTheme

@Composable
fun ConsumerTextField(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFEFEFF2),
            unfocusedContainerColor =Color(0xFFEFEFF2),
        )
    )
}

@Composable
@Preview(showBackground=true)
fun ConsumerTextFieldPreview() {
    ConsumerTheme {
        Column(modifier = Modifier.padding(16.dp)){ ConsumerTextField() }
    }

}