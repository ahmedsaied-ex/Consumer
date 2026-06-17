package com.example.consumer.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.cards.ConsumerCostumeCard
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle1
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.divider__dot_
import consumer.composeapp.generated.resources.ic_cart
import org.jetbrains.compose.resources.painterResource

@Composable
fun MyCartCard(
    modifier: Modifier = Modifier,
    numberOfItems: Int = 5,
    title: String = "الطلبات الشهرية",
    date: String? = "22 ابريل 2026"
) {
    ConsumerCostumeCard {
        Row(
            modifier = Modifier.fillMaxWidth().height(100.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier.padding(start = 20.dp, end = 16.dp).size(60.dp)
                    .background(
                        shape = RoundedCornerShape(DesignSystem.Radius.RadiusMd),
                        color = MaterialTheme.colorScheme.extendedColors.profileSectionEvenItemBackgroundColor
                    ), contentAlignment = Alignment.Center
            ) {
                Image(painterResource(Res.drawable.ic_cart), contentDescription = null)
            }

            Column {

                Text(
                    title,
                    style = Subtitle1.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
                if (numberOfItems > 0) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "$numberOfItems",
                            style = Subtitle3.copy(fontWeight = FontWeight.Medium),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            "منتجات", style = Subtitle3.copy(fontWeight = FontWeight.Normal),
                            color = MaterialTheme.colorScheme.extendedColors.darkBlue650
                        )
                        Spacer(modifier = Modifier.width(6.dp))

                        Image(
                            painterResource(Res.drawable.divider__dot_),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            "اخر تحديث", style = Subtitle3.copy(fontWeight = FontWeight.Normal),
                            color = MaterialTheme.colorScheme.extendedColors.darkBlue650
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        if (date != null) {
                            Text(
                                date, style = Subtitle3.copy(fontWeight = FontWeight.Medium),
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }
                } else {
                    Text(
                        "لم يتم إضافة منتجات للسلة",
                        style = Subtitle3.copy(fontWeight = FontWeight.Normal),
                        color = MaterialTheme.colorScheme.extendedColors.darkBlue650
                    )
                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun MyCartCardPreview() {
    ConsumerTheme {
        MyCartCard()
    }

}