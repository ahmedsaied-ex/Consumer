package com.example.consumer.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.cards.ConsumerCostumeCard
import com.example.consumer.core.presentation.components.utils.PriceRow
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle1
import com.example.consumer.core.presentation.theme.ConsumerTheme
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ic_date_time
import consumer.composeapp.generated.resources.ic_duration
import org.jetbrains.compose.resources.painterResource


@Composable
fun ConsultationRequestCard(
    modifier: Modifier = Modifier,
    date: String = "20 مايو 2026",
    time: String = "12:30 م",
    min: String = "30 دقيقة",
    price: String = "25.5"
) {
    ConsumerCostumeCard {
        Column(
            modifier = Modifier.padding(DesignSystem.Padding.Padding2XL)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "استشارة حقوق المستهلك",
                    style = Subtitle1.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colorScheme.onBackground
                )

                PriceRow(value = price)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painterResource(Res.drawable.ic_date_time),
                    contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    date,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = Subtitle1.copy(fontWeight = FontWeight.Normal)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "-",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = Subtitle1.copy(fontWeight = FontWeight.Normal)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    time,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = Subtitle1.copy(fontWeight = FontWeight.Normal)
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(Res.drawable.ic_duration),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(min, style = Subtitle1.copy(fontWeight = FontWeight.Normal))
            }
        }
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun ConsultationRequestCardPreview() {
    ConsumerTheme {
        ConsultationRequestCard()
    }

}