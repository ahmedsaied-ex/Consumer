package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.utils.AsyncImageProduct
import com.example.consumer.core.presentation.components.utils.CircularIcon
import com.example.consumer.core.presentation.foundation.DesignSystem.ConsumerDimensions.Padding.padding3xl
import com.example.consumer.core.presentation.foundation.typography.Subtitle2
import com.example.consumer.core.presentation.theme.ConsumerTheme

@Composable
fun SelectableProductCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    productName: String,
    isSelectable: Boolean = false,
    isSelected: Boolean = false,
) {
    ConsumerCostumeCard {
        Row(
            modifier = modifier.padding(padding3xl).fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularIcon(isSelectable = isSelectable, isSelected = isSelected)
            AsyncImageProduct(size = 60, imageUrl = imageUrl)
            Text(
                productName,
                style = Subtitle2.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}


@Composable
@Preview(showBackground = true, locale = "ar")
fun SelectableProductCardPreview() {
    ConsumerTheme {
        Column (modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            SelectableProductCard(
                imageUrl = "",
                isSelectable = true,
                isSelected = true,
                productName = "تاج الهند أرز بسمتي أبيض طويل الحبة الدرجة الأولى 5 كجم"
            )
            SelectableProductCard(
                imageUrl = "",
                isSelectable = true,
                isSelected = false,
                productName = "تاج الهند أرز بسمتي أبيض طويل الحبة الدرجة الأولى 5 كجم"
            )
            SelectableProductCard(
                imageUrl = "",
                isSelectable = false,
                isSelected = true,
                productName = "تاج الهند أرز بسمتي أبيض طويل الحبة الدرجة الأولى 5 كجم"
            )
        }
    }

}

