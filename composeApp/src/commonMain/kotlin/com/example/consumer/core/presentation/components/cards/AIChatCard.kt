package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.theme.ConsumerTheme
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ai_chat_card_background
import consumer.composeapp.generated.resources.ai_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun AIChatCard(
    modifier: Modifier = Modifier
) {
    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color(0xFF6A11CB), Color(0xFF2575FC)),
        start = androidx.compose.ui.geometry.Offset(0f, 0f),
        end = androidx.compose.ui.geometry.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
    )

    Card(modifier = modifier.fillMaxWidth().height(122.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter =painterResource(
                    Res.drawable.ai_chat_card_background
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Row(modifier = Modifier.padding(20.dp).fillMaxSize(),verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.border(
                    width = 1.dp,
                    brush = gradientBrush,
                    shape = CircleShape

                )){
                    Image(
                        painter =painterResource(
                            Res.drawable.ai_icon
                        ),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground=true , locale = "ar")
fun AIChatCardPreview() {
    ConsumerTheme {
        AIChatCard()
    }

}