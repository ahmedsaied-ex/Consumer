package com.example.consumer.core.presentation.components.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.theme.ConsumerTheme
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ic_jpg
import consumer.composeapp.generated.resources.ic_pdf
import consumer.composeapp.generated.resources.ic_png
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun LocalImageBoxBorder(
    modifier: Modifier = Modifier,
    size: Int = 48,
    resource: DrawableResource
) {
    Box(
        modifier = modifier.size(size.dp).border(
            width = 1.dp,
            brush = SolidColor(MaterialTheme.colorScheme.onPrimary),
            shape = RoundedCornerShape(DesignSystem.Radius.RadiusMd)
        ),
        contentAlignment =  androidx.compose.ui.Alignment.Center
    ){
        Image(painterResource(resource), contentDescription = null)
    }
}

@Composable
@Preview(showBackground=true , locale = "ar")
fun LocalImageBoxBorderPreview() {
    ConsumerTheme {
        Column(Modifier.padding(DesignSystem.Padding.Padding2XL),
     verticalArrangement = Arrangement.spacedBy(DesignSystem.Padding.Padding2XL)){
        LocalImageBoxBorder(resource = Res.drawable.ic_pdf)
        LocalImageBoxBorder(resource = Res.drawable.ic_jpg)
        LocalImageBoxBorder(resource = Res.drawable.ic_png)
    }
}
}