package com.example.consumer.features.languageSelection.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.example.consumer.core.data.AppLang
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.H6
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.language
import org.jetbrains.compose.resources.stringResource

@Composable
fun LanguageCard(
    selectedLanguage: AppLang,
    onLanguageSelected: (AppLang) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(DesignSystem.Radius.Radius4XL))
            .background(MaterialTheme.colorScheme.extendedColors.profileSectionEvenItemBackgroundColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.language),
            color = MaterialTheme.colorScheme.onBackground,
            style = H6.copy(fontWeight = FontWeight.Medium)
        )

        Spacer(modifier = Modifier.height(20.dp))
        LanguageItem(
            title = "العربية",
            selected = selectedLanguage == AppLang.ARABIC,
            onClick = { onLanguageSelected(AppLang.ARABIC) }
        )
        Spacer(modifier = Modifier.height(15.dp))

        LanguageItem(
            title = "ENGLISH",
            selected = selectedLanguage == AppLang.ENGLISH,
            onClick = { onLanguageSelected(AppLang.ENGLISH) }
        )


    }
}


@Composable
@Preview(showBackground=true)
fun PreviewLanguageCard() {
    ConsumerTheme {
        LanguageCard(selectedLanguage = AppLang.ARABIC, onLanguageSelected = {})
    }

}