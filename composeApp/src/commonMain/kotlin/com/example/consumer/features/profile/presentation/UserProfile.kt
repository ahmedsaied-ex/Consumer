package com.example.consumer.features.profile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.consumer.core.presentation.components.CostumeScaffold
import com.example.consumer.core.presentation.components.bars.TransparentToolbar
import com.example.consumer.core.presentation.components.cards.AIAssistantCard
import com.example.consumer.core.presentation.components.lines.HorizontalLine
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import com.example.consumer.features.profile.domain.models.SectionItem
import com.example.consumer.features.profile.domain.models.SuffixType
import com.example.consumer.features.profile.presentation.components.ProfileSection
import com.example.consumer.features.profile.presentation.components.ProfileTopPart
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.app_lang
import consumer.composeapp.generated.resources.basic_info
import consumer.composeapp.generated.resources.birth_date
import consumer.composeapp.generated.resources.change_email
import consumer.composeapp.generated.resources.country
import consumer.composeapp.generated.resources.edit_info
import consumer.composeapp.generated.resources.gender
import consumer.composeapp.generated.resources.id_number
import consumer.composeapp.generated.resources.log_out
import consumer.composeapp.generated.resources.logout_icon
import consumer.composeapp.generated.resources.privacy_policy
import consumer.composeapp.generated.resources.settings
import consumer.composeapp.generated.resources.terms_and_conditions
import consumer.composeapp.generated.resources.usage_policy
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun UserProfile(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val basicItems = listOf(
        SectionItem.Static(stringResource(Res.string.country), "المملكة العربية السعودية"),
        SectionItem.Static(stringResource(Res.string.id_number), "9545121704552255"),
        SectionItem.Static(stringResource(Res.string.birth_date), "19/5/2000"),
        SectionItem.Static(stringResource(Res.string.gender), "ذكر"),
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
    val privacyAndTerms = listOf(
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
    CostumeScaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TransparentToolbar(
                navController = navController, title = "ملفي الشخصي"
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = DesignSystem.Padding.Padding2XL).fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Padding.Padding2XL)
        ) {
            item {
                ProfileTopPart(
                    name = "عمرو عبد الله",
                    imageUrl = "",
                    selectedImageBytes = null,
                    isUploadingImage = false,
                    onImageClick = {}
                )
            }
            item { AIAssistantCard() }
            item { HorizontalLine() }
            item {
                ProfileSection(
                    title = Res.string.basic_info,
                    items = basicItems
                )
            }
            item { HorizontalLine() }
            item {
                ProfileSection(
                    title = Res.string.settings,
                    items = settingsItems
                )
            }
            item { HorizontalLine() }
            item {
                ProfileSection(
                    title = Res.string.usage_policy,
                    items = privacyAndTerms
                )
            }
            item {
                Button(
                    contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp),
                    onClick = {},
                    shape = RoundedCornerShape(DesignSystem.Radius.RadiusSm),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.extendedColors.logOutButtonBackground,
                        contentColor = MaterialTheme.colorScheme.onError
                    ),
                ){
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(painterResource(Res.drawable.logout_icon),contentDescription = null, modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(stringResource(Res.string.log_out), style = Subtitle3.copy(fontWeight = FontWeight.SemiBold))
                    }
                }
            }


        }

    }
}


@Composable
@Preview(showBackground = true, locale = "ar", heightDp = 1200)
fun UserProfilePreview() {
    ConsumerTheme {
        UserProfile()
    }

}