package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.border
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import coil3.Image
import coil3.compose.AsyncImage
import com.example.consumer.core.presentation.components.utils.AsyncImageProduct
import com.example.consumer.core.presentation.components.utils.PriceRow
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.price_start_with
import consumer.composeapp.generated.resources.sold_from
import org.jetbrains.compose.resources.stringResource

@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    soldFrom: String,
    description: String,
    price: Any,
    imageUrl : String
) {
    ConsumerCostumeCard {
        Row(
            modifier = Modifier.padding(20.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImageProduct(size = 100, imageUrl = imageUrl)

            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(Res.string.price_start_with),
                    style = Subtitle3.copy(color = MaterialTheme.colorScheme.extendedColors.darkBlue650)
                )
                PriceRow(
                    value = price,
                )
                Row {
                    Text(
                        text = stringResource(Res.string.sold_from),
                        style = Subtitle3.copy(color = MaterialTheme.colorScheme.extendedColors.darkBlue650)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = soldFrom,
                        style = Subtitle3.copy(
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = description,
                    style = Subtitle3.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun ConsumerCostumeCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.dropShadow(
            shape = RoundedCornerShape(DesignSystem.Radius.RadiusXL),
            shadow = Shadow(
                radius = 16.dp,
                spread = (-2).dp,
                color = Color.Black.copy(alpha = 0.12f),
                offset = DpOffset(
                    x = 0.dp,
                    y = 10.dp
                )
            )
        ),
        shape = RoundedCornerShape(DesignSystem.Radius.RadiusXL),
    ){
        content()
    }
}


@Composable
@Preview(showBackground = true, locale = "ar")
fun ItemCardPreview() {
    ConsumerTheme {
        Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center) {
            ItemCard(
                price = 18200.22,
                soldFrom = "مكتبة جرير",
                description = "شاشة تلفزيون سمارت هاير ، مقاس 65 بوصة ، ليد ، دقة 4K UHD ، بريسيفر داخلي",
                imageUrl = ""
            )
        }
    }

}