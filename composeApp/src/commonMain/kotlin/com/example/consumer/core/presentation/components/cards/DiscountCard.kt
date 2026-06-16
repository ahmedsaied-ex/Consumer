package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle1
import com.example.consumer.core.presentation.foundation.typography.Subtitle2
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.branches
import consumer.composeapp.generated.resources.calender
import consumer.composeapp.generated.resources.free_discovery_mission
import consumer.composeapp.generated.resources.high_priority
import consumer.composeapp.generated.resources.ic_free_discover
import consumer.composeapp.generated.resources.low_priority
import consumer.composeapp.generated.resources.mid_priority
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

enum class PriorityTypes {
    LOW, MEDIUM, HIGH
}

enum class MarketTypes {
    ONLINE,
    ONSITE,
    FREE_DISCOVER

}


@Composable
fun DiscountCard(
    modifier: Modifier = Modifier,
    priorityType: PriorityTypes,
    marketType: MarketTypes,
    marketName: String?,
    numberOfBranches: Int?
) {
    ConsumerCostumeCard(modifier = modifier.fillMaxWidth()) {
        Column {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                GreenSideBar(modifier = Modifier.padding(vertical = 14.dp))
                Column(modifier = Modifier.padding(14.dp)) {
                    PriorityType(
                        priorityType = priorityType
                    )
                    Text(
                        "رصد تخفيضات نهاية الموسم — الرياض",
                        style = Subtitle1.copy(
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 14.dp)) {
                InspectionType(
                    modifier = Modifier.weight(1f),
                    inspectionTitle = "تخفيض موسمي"
                )
                Spacer(modifier = Modifier.width(10.dp))
                DiscountFullDate(
                    modifier = Modifier.weight(2f),
                    startDate = "20 مايو 2026",
                    endDate = "10 يونيو 2026"
                )
            }
            MarketPlace(
                marketType = marketType,
                numberOfBranches = numberOfBranches,
                marketName = marketName
            )
        }
    }
}


@Composable
fun MarketPlace(
    modifier: Modifier = Modifier,
    marketType: MarketTypes,
    marketName : String?,
    numberOfBranches: Int?
) {
    Box(
        modifier = modifier.padding(vertical = 14.dp, horizontal = 14.dp).fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    DesignSystem.Radius.RadiusLg
                )
            ).border(
                width = 1.dp,
                brush = SolidColor(MaterialTheme.colorScheme.extendedColors.profileSectionEvenItemBackgroundColor),
                shape = RoundedCornerShape(DesignSystem.Radius.RadiusLg)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (marketType) {
                MarketTypes.FREE_DISCOVER -> {
                    Box(
                        modifier = modifier.size(48.dp)
                            .clip(RoundedCornerShape(DesignSystem.Radius.RadiusMd))
                            .background(MaterialTheme.colorScheme.extendedColors.tabBarColorTabsBackground)
                            .border(
                                width = 1.dp,
                                brush = SolidColor(MaterialTheme.colorScheme.onPrimary),
                                shape = RoundedCornerShape(DesignSystem.Radius.RadiusMd)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painterResource(Res.drawable.ic_free_discover),
                            contentDescription = null
                        )
                    }
                }

                else -> {
                    AsyncImageProduct(
                        imageUrl = "",
                        size = 48
                    )
                }
            }
            Spacer(Modifier.width(10.dp))

            Column {
                Text(
                    marketName?:stringResource(Res.string.free_discovery_mission),
                    style = Subtitle2.copy(color = MaterialTheme.colorScheme.onBackground)
                )

                when (marketType) {
                    MarketTypes.ONSITE -> {
                        Row {
                            Text(
                                (numberOfBranches ?: 0).toString(),
                                style = Subtitle2.copy(
                                    MaterialTheme.colorScheme.onBackground,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Spacer(Modifier.width(2.dp))
                            Text(
                                stringResource(Res.string.branches), style = Subtitle2.copy(
                                    MaterialTheme.colorScheme.extendedColors.darkBlue650,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                    }

                    else -> {}
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun MarketPlacePreview() {
    Column(Modifier.padding(DesignSystem.Padding.Padding2XL)) {
        ConsumerTheme {
            MarketPlace(
                marketType = MarketTypes.FREE_DISCOVER,
                numberOfBranches = null,
                marketName = "مهمة اكتشاف مفتوحة"
            )
        }
    }
}


@Composable
fun PriorityType(
    modifier: Modifier = Modifier,
    priorityType: PriorityTypes
) {

    val color = when (priorityType) {
        PriorityTypes.LOW -> MaterialTheme.colorScheme.extendedColors.lowPriorityColor
        PriorityTypes.MEDIUM -> MaterialTheme.colorScheme.extendedColors.midPriorityColor
        PriorityTypes.HIGH -> MaterialTheme.colorScheme.extendedColors.highPriorityColor
    }
    val text = when (priorityType) {
        PriorityTypes.LOW -> stringResource(Res.string.low_priority)
        PriorityTypes.MEDIUM -> stringResource(Res.string.mid_priority)
        PriorityTypes.HIGH -> stringResource(Res.string.high_priority)
    }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier.size(5.dp).clip(CircleShape)
                .background(
                    color.copy(
                        alpha = 0.5f
                    )
                )
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text,
            style = Subtitle3.copy(color)
        )
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun PriorityTypePreview() {
    Column(
        Modifier.padding(DesignSystem.Padding.Padding2XL),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ConsumerTheme {
            PriorityType(
                priorityType = PriorityTypes.LOW
            )
            PriorityType(
                priorityType = PriorityTypes.MEDIUM
            )
            PriorityType(
                priorityType = PriorityTypes.HIGH
            )
        }
    }
}


@Composable
fun InspectionType(
    modifier: Modifier = Modifier,
    inspectionTitle: String
) {
    Box(
        modifier = modifier.clip(RoundedCornerShape(DesignSystem.Radius.Radius1xs))
            .background(MaterialTheme.colorScheme.extendedColors.profileSectionEvenItemBackgroundColor)
            .padding(vertical = 6.dp, horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            inspectionTitle,
            style = Subtitle3.copy(color = MaterialTheme.colorScheme.primary)
        )

    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun InspectionTypePreview() {
    ConsumerTheme {
        InspectionType(
            inspectionTitle = "تخفيض موسمي"

        )
    }
}


@Composable
fun DiscountFullDate(
    modifier: Modifier = Modifier,
    startDate: String,
    endDate: String
) {
    Box(
        modifier = modifier.clip(RoundedCornerShape(DesignSystem.Radius.Radius1xs))
            .background(MaterialTheme.colorScheme.extendedColors.profileSectionEvenItemBackgroundColor)
            .padding(vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            DiscountDateRow(date = startDate)
            Spacer(modifier = Modifier.width(8.dp))
            DiscountDateRow(date = endDate)
        }

    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun DiscountFullDatePreview() {
    ConsumerTheme {
        DiscountFullDate(startDate = "20 مايو 2026", endDate = "10 يونيو 2026")
    }

}

@Composable
fun DiscountDateRow(
    modifier: Modifier = Modifier,
    date: String
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(painterResource(Res.drawable.calender), contentDescription = null)
        Spacer(modifier = Modifier.width(4.dp))

        Text(
            date,
            style = Subtitle3.copy(color = MaterialTheme.colorScheme.extendedColors.buttonSecondaryLabelIcon)
        )
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun DiscountDateRowPreview() {
    ConsumerTheme {
        DiscountDateRow(date = "20 مايو 2026")
    }

}

@Composable
@Preview(showBackground = true, locale = "ar")
fun DiscountCardPreview() {
    ConsumerTheme {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)){
            DiscountCard(
                priorityType = PriorityTypes.LOW,
                marketType = MarketTypes.FREE_DISCOVER,
                numberOfBranches = 6,
                marketName = "marketName"
            )
            DiscountCard(
                priorityType = PriorityTypes.LOW,
                marketType = MarketTypes.FREE_DISCOVER,
                numberOfBranches = 6,
                marketName = "marketName"
            )
            DiscountCard(
                priorityType = PriorityTypes.LOW,
                marketType = MarketTypes.FREE_DISCOVER,
                numberOfBranches = 6,
                marketName = "marketName"
            )
        }
    }

}