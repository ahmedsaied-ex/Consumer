package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle1
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ic_specific_link
import org.jetbrains.compose.resources.painterResource

@Composable
fun CardWithLink(
    modifier: Modifier = Modifier,
    title:String,
    linkText:String,
    sourceType: String,
    fraudType: String

) {
    val uriHandler = LocalUriHandler.current

    ConsumerCostumeCard(modifier = modifier) {
        Column(
            modifier = Modifier.padding(DesignSystem.Padding.Padding2XL)
        ) {
            Text(
               title,
                style = Subtitle1.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    fraudType,
                    style = Subtitle3.copy(
                        color = MaterialTheme.colorScheme.extendedColors.buttonSecondaryLabelIcon,
                    )
                )
                Box(
                    modifier = Modifier.height((1.2).dp).width(4.dp)
                        .background(MaterialTheme.colorScheme.extendedColors.darkBlue400)
                )
                Text(
                    sourceType,
                    style = Subtitle3.copy(
                        color = MaterialTheme.colorScheme.extendedColors.darkBlue650,
                    )
                )
            }
            Spacer(modifier = Modifier.height(DesignSystem.Padding.PaddingXL))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(DesignSystem.Radius.Radius1xs)).background(
                    MaterialTheme.colorScheme.extendedColors.profileSectionEvenItemBackgroundColor
                ).padding(DesignSystem.Padding.PaddingMd),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(DesignSystem.Radius.RadiusSm)).background(White)
                        .border(
                            width = 1.dp,
                            brush = SolidColor(MaterialTheme.colorScheme.extendedColors.tabBarColorTabsBackground),
                            shape = RoundedCornerShape(DesignSystem.Radius.RadiusSm)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(painterResource(Res.drawable.ic_specific_link),
                        contentDescription = null , modifier = Modifier.padding(DesignSystem.Padding.PaddingMd))
                }
                Spacer(Modifier.width(DesignSystem.Padding.PaddingSm))
                Text(
                    buildAnnotatedString {
                        pushStringAnnotation(
                            tag = "URL",
                            annotation = linkText
                        )
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = Subtitle3.fontSize,

                                color = MaterialTheme.colorScheme.extendedColors.blueSapphire700,
                            )
                        ) {
                            append(linkText)
                        }
                        pop()
                    },
                    modifier = Modifier.clickable {
                        uriHandler.openUri(linkText)
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun CardWithLinkPreview() {
    ConsumerTheme {
        Box(modifier = Modifier.padding(16.dp)) { CardWithLink(
            title = "التحقق من إعلانات المكملات الغذائية",
            linkText = "https://saudi-discounts-offers.store",
            sourceType ="موقع إلكتروني",
            fraudType = "احتيال مالي"
        ) }
    }

}