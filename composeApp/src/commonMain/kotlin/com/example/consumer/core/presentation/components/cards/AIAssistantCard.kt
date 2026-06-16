package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.buttons.ButtonsTypes
import com.example.consumer.core.presentation.components.buttons.ConsumerFilledButton
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle1
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.AIAssistantcard
import consumer.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun AIAssistantCard(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth().height(115.dp).clip(
            shape = RoundedCornerShape(DesignSystem.Radius.RadiusXL)
        ),
    ) {
        Image(
            painterResource(Res.drawable.AIAssistantcard),
            contentDescription = null,
            Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Row(Modifier.fillMaxSize().padding(horizontal = 20.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {

            Column {
                Text(
                    "باقتك الحالية",
                    style = Subtitle3.copy(color = MaterialTheme.colorScheme.extendedColors.darkBlue150)
                )
                Text(
                    "بلص",
                    style = Subtitle1.copy(
                        color = MaterialTheme.colorScheme.extendedColors.darkBlue100,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(Modifier.height(6.dp))
                Row {
                    Text(
                        "باقة سنوية تنتهي في:",
                        style = Subtitle3.copy(color = MaterialTheme.colorScheme.extendedColors.darkBlue100)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        "19/5/2027",
                        style = Subtitle3.copy(
                            color = MaterialTheme.colorScheme.extendedColors.darkBlue100,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
            ConsumerFilledButton(
                text = "ترقية الباقة",
                type = ButtonsTypes.PRIMARY,
                enabled = true,
                onClick = {},
            )
        }

    }
}

@Composable
@Preview(showBackground = false, locale = "ar")
fun AIAssistantCardPreview() {
    ConsumerTheme {
        AIAssistantCard()
    }

}