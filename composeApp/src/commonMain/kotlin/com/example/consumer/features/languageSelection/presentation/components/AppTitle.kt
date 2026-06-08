package com.example.consumer.features.languageSelection.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.consumer.core.presentation.foundation.typography.H4
import com.example.consumer.core.presentation.theme.ConsumerTheme
import consumer.composeapp.generated.resources.AppName
import consumer.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppTitle(
    modifier: Modifier = Modifier
) {
    Text(stringResource(Res.string.AppName),
        style = H4.copy(fontWeight = FontWeight.Bold), color = MaterialTheme.colorScheme.primary
    )
}

@Composable
@Preview(showBackground = true)
fun AppTitlePreview() {
    ConsumerTheme {
        AppTitle()
    }

}