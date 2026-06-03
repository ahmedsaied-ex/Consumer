package com.example.consumer.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.typography.H1
import com.example.consumer.core.presentation.theme.ConsumerTheme

@Composable
fun TestColorScheme(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .size(100.dp)
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            onClick = {},
            content = {
                Text("حذف السلة",
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold))
            }
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            onClick = {},
            content = {
                Text("Click me", style = H1)
            }
        )
        OutlinedButton(
            onClick = {},
        ){}
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
            ),
            onClick = {},
            content = {
                Text("Click me")
            }
        )
        RadioButton(
            selected = true,
            onClick = {},

        )
    }
}

@Composable
@Preview(showBackground = true)
fun TestColorSchemePreview() {
    ConsumerTheme { TestColorScheme() }

}


