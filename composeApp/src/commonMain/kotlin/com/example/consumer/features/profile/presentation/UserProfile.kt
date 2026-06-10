package com.example.consumer.features.profile.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.consumer.core.presentation.theme.ConsumerTheme

@Composable
fun UserProfile(
    modifier: Modifier = Modifier
) {

}

@Composable
@Preview(showBackground=true , locale = "ar")
fun UserProfilePreview() {
    ConsumerTheme {
        UserProfile()
    }

}