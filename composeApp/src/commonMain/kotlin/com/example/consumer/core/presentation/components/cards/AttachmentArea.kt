package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.utils.dashedBorder
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Button1
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.file_types
import consumer.composeapp.generated.resources.ic_upload
import consumer.composeapp.generated.resources.mega
import consumer.composeapp.generated.resources.supported_files
import consumer.composeapp.generated.resources.upload_or_choose_file
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun AttachmentArea(
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .dashedBorder(
                color = MaterialTheme.colorScheme.extendedColors.blueSapphire700,
                shape = RoundedCornerShape(DesignSystem.Radius.RadiusMd),
                dashWidth = 9.dp,
                gapWidth = 10.dp
            ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.extendedColors.profileSectionEvenItemBackgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = DesignSystem.Padding.Padding4XL,
                horizontal = DesignSystem.Padding.Padding2XL
            ).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource(Res.drawable.ic_upload), contentDescription = null)
            Spacer(Modifier.height(12.dp))
            Text(
                stringResource(Res.string.upload_or_choose_file),
                style = Button1.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.tertiary
                )
            )
            Spacer(Modifier.height(4.dp))
            Row {
                Text(
                    stringResource(Res.string.supported_files),
                    style = Subtitle3.copy(color = MaterialTheme.colorScheme.extendedColors.darkBlue650)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    stringResource(Res.string.file_types),
                    style = Subtitle3.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
            Row {
                Text(
                    "الحجم الأقصى للملف",
                    style = Subtitle3.copy(color = MaterialTheme.colorScheme.extendedColors.darkBlue650)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    "5 ${stringResource(Res.string.mega)}",
                    style = Subtitle3.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }

    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun AttachmentAreaPreview() {
    ConsumerTheme {
        Column(
            Modifier.padding(DesignSystem.Padding.Padding2XL),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Padding.Padding2XL)
        ) {
            AttachmentArea()
            UploadedDocumentCard(
                name = "IMG_2026511_25655",
                types = UploadedDocumentTypes.PDF,
                size = "2.1 MB"
            )
        }
    }
}


