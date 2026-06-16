package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.consumer.core.presentation.components.utils.CircularIcon
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle2
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors

@Composable
fun BottomSheetSelectableCard(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    imageUrl: String,
    productName: String
) {
    BaseSelectableBox(
        modifier = modifier,
        isSelected = isSelected
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CircularIcon(isSelectable = true, isSelected = isSelected)
            AsyncImageProduct(size = 80, imageUrl = imageUrl)
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
fun BottomSheetSelectableCardPreview() {
    ConsumerTheme {
        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)){
            BottomSheetSelectableCard(
                isSelected = true,
                imageUrl = "",
                productName = "شاشة تلفزيون سمارت سامسونج ، مقاس 65 بوصة ، ليد ، دقة 4K UHD ، بريسيفر داخلي"
            )
            BottomSheetSelectableCard(
                isSelected = false ,
                imageUrl = "",
                productName = "شاشة تلفزيون سمارت سامسونج ، مقاس 65 بوصة ، ليد ، دقة 4K UHD ، بريسيفر داخلي"
            )
        }
    }

}

@Composable
fun BaseSelectableBox(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    content :@Composable () ->Unit
) {
    Box(
        modifier = modifier.fillMaxWidth()
            .clip(shape = RoundedCornerShape(DesignSystem.Radius.RadiusXL)).border(
                width = if (isSelected) 2.dp else 1.dp,
                brush = SolidColor(if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.extendedColors.starterCircleColor),
                shape = RoundedCornerShape(DesignSystem.Radius.RadiusXL)
            )
            .padding(DesignSystem.Padding.Padding3XL)
    ) {
        content()
    }
}

@Composable
@Preview(showBackground=true , locale = "ar")
fun BaseSelectableBoxPreview() {
    Column(Modifier.padding(DesignSystem.Padding.Padding2XL)){
        ConsumerTheme {
        BaseSelectableBox( isSelected = false ){}
    }
}
}