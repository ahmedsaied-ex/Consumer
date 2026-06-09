package com.example.consumer.features.completeProfile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.consumer.core.presentation.components.bars.TransparentToolbar
import com.example.consumer.core.presentation.components.ConsumerTextField
import com.example.consumer.core.presentation.theme.ConsumerTheme


@Composable
fun CompleteProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),

    ) {
    ConsumerTheme {
        Column (modifier= Modifier.fillMaxSize()){
            TransparentToolbar(
                title = "أدخل معلوماتك الأساسية",
                navController = navController

            )
            Column(modifier= Modifier.padding(horizontal = 16.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                ConsumerTextField(
                    labelText="الاسم الأول",
                    modifier = Modifier.weight(1f)
                )
                ConsumerTextField(labelText="الاسم الأخير",
                    modifier = Modifier.weight(1f)
                )
            }}
        }
    }

}

@Composable
@Preview(showBackground = true, locale = "ar")
fun CompleteProfileScreenPreview() {
    ConsumerTheme {
        CompleteProfileScreen()
    }

}