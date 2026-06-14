package com.example.consumer.core.presentation.components.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.theme.ConsumerTheme

@Composable
fun AsyncImageProduct(
    modifier: Modifier = Modifier,
    size: Int = 60,
    imageUrl: String?
) {
    Box(
        modifier = modifier.size(size.dp).border(
            width = 1.dp,
            brush = SolidColor(MaterialTheme.colorScheme.onPrimary),
            shape = RoundedCornerShape(DesignSystem.Radius.RadiusMd)
        )
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
@Preview(showBackground=true , locale = "ar")
fun AsyncImageProductPreview() {
    ConsumerTheme {
        AsyncImageProduct(imageUrl = "")
    }

}