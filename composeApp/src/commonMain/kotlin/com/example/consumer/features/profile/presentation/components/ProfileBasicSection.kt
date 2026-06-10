package com.example.consumer.features.profile.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import com.example.consumer.features.profile.domain.models.SectionItem
import com.example.consumer.features.profile.domain.models.SuffixType
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.app_lang
import consumer.composeapp.generated.resources.basic_info
import consumer.composeapp.generated.resources.birth_date
import consumer.composeapp.generated.resources.change_email
import consumer.composeapp.generated.resources.chevron_left
import consumer.composeapp.generated.resources.country
import consumer.composeapp.generated.resources.edit_info
import consumer.composeapp.generated.resources.gender
import consumer.composeapp.generated.resources.id_number
import consumer.composeapp.generated.resources.privacy_policy
import consumer.composeapp.generated.resources.settings
import consumer.composeapp.generated.resources.terms_and_conditions
import consumer.composeapp.generated.resources.usage_policy
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier,
    title: StringResource,
    items: List<SectionItem>,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.extendedColors.darkBlue650
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(12.dp))

        Column(modifier = Modifier.clip(RoundedCornerShape(6))) {
            items.forEachIndexed { index, item ->
                ProfileSectionItem(index = index, item = item)
            }
        }

    }
}

@Composable
fun ProfileSectionItem(
    modifier: Modifier = Modifier,
    index: Int,
    item: SectionItem
) {
    val isEven = index % 2 == 0
    val background = if (isEven)
        MaterialTheme.colorScheme.extendedColors.profileSectionEvenItemBackgroundColor
    else
        MaterialTheme.colorScheme.extendedColors.profileSectionOddItemBackgroundColor

    val baseModifier = modifier
        .fillMaxWidth()
        .background(background)
        .padding(vertical = 12.dp, horizontal = 16.dp)

    when (item) {
        is SectionItem.Static -> {
            Row(
                modifier = baseModifier,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(item.key),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.extendedColors.darkBlue650
                )
                Text(
                    text = item.value,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        is SectionItem.Clickable -> {
            Row(
                modifier = baseModifier.clickable { item.onClick() },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(item.title),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                when (val suffix = item.suffix) {
                    is SuffixType.ChevronOnly -> {
                        Image(
                            painter = painterResource(Res.drawable.chevron_left),
                            contentDescription = null
                        )
                    }

                    is SuffixType.TextAndChevron -> {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = suffix.label,
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.extendedColors.darkBlue650
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Image(
                                painter = painterResource(Res.drawable.chevron_left),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = false, locale = "ar")
fun ProfileBasicSectionsPreview() {
    ConsumerTheme {
        val basicItems = listOf(
            SectionItem.Static(Res.string.country, "المملكة العربية السعودية"),
            SectionItem.Static(Res.string.id_number, "9545121704552255"),
            SectionItem.Static(Res.string.birth_date, "19/5/2000"),
            SectionItem.Static(Res.string.gender, "ذكر"),
        )

        val settingsItems = listOf(
            SectionItem.Clickable(
                title = Res.string.edit_info,
                suffix = SuffixType.ChevronOnly,
                onClick = { /* navigate */ }
            ),
            SectionItem.Clickable(
                title =  Res.string.change_email,
                suffix = SuffixType.ChevronOnly,
                onClick = { /* navigate */ }
            ),
            SectionItem.Clickable(
                title =  Res.string.app_lang,
                suffix = SuffixType.TextAndChevron("العربية"),
                onClick = { /* open language picker */ }
            ),
        )

        val privacyAndterms = listOf(
            SectionItem.Clickable(
                title =  Res.string.privacy_policy,
                suffix = SuffixType.ChevronOnly,
                onClick = { /* navigate */ }
            ),
            SectionItem.Clickable(
                title = Res.string.terms_and_conditions,
                suffix = SuffixType.ChevronOnly,
                onClick = { /* navigate */ }
            ),
        )

        LazyColumn {
            item {
                ProfileSection(
                    title = Res.string.basic_info,
                    items = basicItems
                )
            }
            item {
                ProfileSection(
                    title = Res.string.settings,
                    items = settingsItems
                )
            }
            item {
                ProfileSection(
                    title =Res.string.usage_policy,
                    items = privacyAndterms
                )
            }

        }
    }

}


//  setting section

@Composable
fun SettingSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            "بياناتي الأساسية",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.extendedColors.darkBlue650
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(12.dp))
        Column(modifier = Modifier.clip(shape = RoundedCornerShape(6))) {
            ClickableProfileItem(
                index = 0,
                title = "سياسة الخصوصية"
            ) {
                Image(
                    painter = painterResource(Res.drawable.chevron_left),
                    contentDescription = null
                )
            }
            ClickableProfileItem(
                index = 0,
                title = "سياسة الخصوصية"
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "العربية",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.extendedColors.darkBlue650,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(Res.drawable.chevron_left),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun ClickableProfileItem(
    modifier: Modifier = Modifier,
    index: Int,
    title: String,
    onClick: () -> Unit = {},
    suffixComposable: @Composable () -> Unit
) {
    val isEven = index % 2 == 0
    Row(
        modifier = modifier.background(
            if (isEven) MaterialTheme.colorScheme.extendedColors.profileSectionEvenItemBackgroundColor
            else MaterialTheme.colorScheme.extendedColors.profileSectionOddItemBackgroundColor
        )
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .clickable(onClick = { onClick() }),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground,
        )
        suffixComposable()
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun ClickableProfileItemPreview() {
    ConsumerTheme {
        ClickableProfileItem(
            index = 1,
            title = "سياسة الخصوصية"
        ) {
            Image(
                painter = painterResource(Res.drawable.chevron_left),
                contentDescription = null
            )

        }

    }


}

@Composable
@Preview(showBackground = true, locale = "ar")
fun SettingSectionPreview() {
    ConsumerTheme {
        SettingSection()
    }

}