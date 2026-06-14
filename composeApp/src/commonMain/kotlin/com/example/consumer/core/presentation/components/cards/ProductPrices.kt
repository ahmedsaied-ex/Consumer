package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.utils.AsyncImageProduct
import com.example.consumer.core.presentation.components.utils.PriceRow
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.best_price
import consumer.composeapp.generated.resources.sold_from
import org.jetbrains.compose.resources.stringResource

@Composable
fun ProductPrices(
    modifier: Modifier = Modifier,
    selected: Boolean,
    isBEstPrice: Boolean,
    soldFrom: String,
    price:Any

) {
    val borderColor = if (selected)  MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.extendedColors.starterCircleColor
    val selectedBorderThickness=  if (selected) 2.dp else  1.dp
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(DesignSystem.Radius.RadiusXL))
            .border(
                width =selectedBorderThickness ,
                brush = SolidColor(borderColor),
                shape = RoundedCornerShape(DesignSystem.Radius.RadiusXL)
            )
    )
    {
        Row(
            Modifier.fillMaxWidth().padding(
                DesignSystem.Padding
                    .Padding3XL
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    PriceRow(
                        value = price
                    )
                    Spacer(Modifier.width(8.dp))
                    if (isBEstPrice){ BestPriceTag() }
                }
                Row {
                    Text(
                        stringResource(Res.string.sold_from),
                        style = Subtitle3.copy(color = MaterialTheme.colorScheme.extendedColors.darkBlue650)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(
                        soldFrom,
                        style = Subtitle3.copy(
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }
            AsyncImageProduct(imageUrl = "", size = 80)
        }
    }
}


@Composable
@Preview(showBackground = true, locale = "ar")
fun ProductPricesSelectedPreview() {
    Column(Modifier.padding(DesignSystem.Padding.Padding2XL), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        ConsumerTheme {
            ProductPrices(
                selected = true,
                isBEstPrice = true,
                soldFrom = "مكتة جرير",
                price = 12545.31,
            )
            ProductPrices(
                selected = false   ,
                isBEstPrice = false,
                soldFrom = "مكتة جرير",
                price = 12545.31,
            )
        }
    }
}

@Composable
fun BestPriceTag(
    modifier: Modifier = Modifier
) {
    Text(
        stringResource(Res.string.best_price),
        style = Subtitle3.copy(
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.error
        ),
        modifier = modifier
            .clip(RoundedCornerShape(DesignSystem.Radius.Radius1xs))
            .background(MaterialTheme.colorScheme.error.copy(alpha = 0.10f))
            .padding(vertical = 2.dp, horizontal = 6.dp)
    )
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun BestPriceTagPreview() {
    Column(Modifier.padding(DesignSystem.Padding.Padding2XL)) {
        ConsumerTheme {
            BestPriceTag()
        }
    }
}