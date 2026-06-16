package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.utils.LocalImageBoxBorder
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ic_delet
import consumer.composeapp.generated.resources.ic_jpg
import consumer.composeapp.generated.resources.ic_pdf
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun UploadedDocumentCard(
    modifier: Modifier = Modifier,
    name: String,
    types: UploadedDocumentTypes,
    size: String
) {
    Box(
        modifier = modifier.fillMaxWidth().height(IntrinsicSize.Min)
            .clip(RoundedCornerShape(DesignSystem.Radius.RadiusMd))
            .background(
                MaterialTheme.colorScheme.extendedColors.cadetBlue150
            ).padding(
                top = DesignSystem.Padding.Padding1xs,
                bottom = DesignSystem.Padding.Padding1xs,
                start = DesignSystem.Padding.PaddingMd,
                end = DesignSystem.Padding.Padding2XL
            ), contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LocalImageBoxBorder(resource = getImageTpe(types))
            Column(
                modifier = Modifier.fillMaxHeight().weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    name,
                    style = Subtitle3.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Medium
                    )
                )
                Text(
                    size,
                    style = Subtitle3.copy(
                        color = MaterialTheme.colorScheme.extendedColors.darkBlue650,
                    )
                )
            }
            Image(painter = painterResource(Res.drawable.ic_delet), contentDescription = null)
        }
    }
}

@Composable
@Preview(showBackground = false, locale = "ar")
fun UploadedDocumentCardPreview() {
    ConsumerTheme {
        Column(
            Modifier.padding(DesignSystem.Padding.Padding2XL),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Padding.Padding2XL)
        ) {
            UploadedDocumentCard(
                name = "IMG_2026511_25655",
                types = UploadedDocumentTypes.PDF,
                size = "2.1 MB"
            )
        }
    }
}

enum class UploadedDocumentTypes {
    PDF,
    PNG,
    JPG
}

fun getImageTpe(type: UploadedDocumentTypes): DrawableResource {
    return when (type) {
        UploadedDocumentTypes.PDF -> Res.drawable.ic_pdf
        UploadedDocumentTypes.PNG -> Res.drawable.ic_jpg
        UploadedDocumentTypes.JPG -> Res.drawable.ic_jpg
    }
}