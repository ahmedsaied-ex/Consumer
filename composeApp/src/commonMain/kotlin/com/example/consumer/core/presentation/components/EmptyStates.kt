package com.example.consumer.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.buttons.ConsumerFilledButton
import com.example.consumer.core.presentation.foundation.typography.Subtitle2
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ic_add
import consumer.composeapp.generated.resources.illustration_no_carts
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Preview(showBackground = true, locale = "ar")
@Composable
fun EmptyStates(image: DrawableResource =  Res.drawable.illustration_no_carts, text: String="لم تقم بإضافة أي سلة") {
    ConsumerTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter =
                    painterResource(image),
                contentDescription = null, modifier = Modifier.size(250.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text, style = Subtitle2, color = MaterialTheme.colorScheme.extendedColors.OTPBoxBorderColor)
            Spacer(modifier = Modifier.height(12.dp))

            ConsumerFilledButton(
                text = "إضافة سلة",
                onClick = {},
                icon = painterResource(Res.drawable.ic_add)


            )
        }
    }
}
