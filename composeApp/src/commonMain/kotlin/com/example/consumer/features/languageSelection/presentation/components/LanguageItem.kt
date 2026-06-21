package com.example.consumer.features.languageSelection.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.cards.SelectedCircle
import com.example.consumer.core.presentation.components.utils.UnSelectedCircularIcon
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.colors.SelectedLanguageItemBackground
import com.example.consumer.core.presentation.foundation.colors.UnSelectedLanguageItemBackground
import com.example.consumer.core.presentation.foundation.typography.Button1
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue

// ...keep your existing imports

@Composable
fun LanguageItem(title: String, selected: Boolean, onClick: () -> Unit) {
    val backgroundColor by animateColorAsState(
        targetValue = if (selected) MaterialTheme.colorScheme.extendedColors.blueSapphire700 else MaterialTheme.colorScheme.extendedColors.tabBarColorTabsBackground,
        animationSpec = tween(durationMillis = 500),
        label = "languageItemBackground"
    )
    val contentColor by animateColorAsState(
        targetValue = if (selected) White else MaterialTheme.colorScheme.primary,
        animationSpec = tween(durationMillis = 500),
        label = "languageItemContent"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(DesignSystem.Radius.RadiusMd))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LanguageSelectionCircle(selected = selected)
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = title,
            color = contentColor,
            style = Button1.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}

@Composable
fun LanguageSelectionCircle(
    modifier: Modifier = Modifier,
    selected: Boolean
) {
    Crossfade(
        targetState = selected,
        animationSpec = tween(durationMillis = 500),
        label = "languageCircleFade"
    ) { isSelected ->
        if (isSelected) {
            SelectedCircle(color = White)
        } else {
            UnSelectedCircularIcon(
                color = MaterialTheme.colorScheme.extendedColors.darkBlue450,
                size = 18
            )
        }
    }
}
//
//@Composable
//fun LanguageSelectionCircle(
//    modifier: Modifier = Modifier,
//    selected: Boolean
//) {
//    if (selected) {
//        SelectedCircle(color = White)
//    } else {
//        UnSelectedCircularIcon(color = MaterialTheme.colorScheme.extendedColors.darkBlue450, size = 18)
//    }
//}

@Composable
@Preview(showBackground=true , locale = "ar")
fun LanguageSelectionCirclePreview() {
    ConsumerTheme {
        Column(Modifier.padding(DesignSystem.Padding.Padding2XL),
     verticalArrangement = Arrangement.spacedBy(DesignSystem.Padding.Padding2XL)){
        LanguageSelectionCircle(
            selected = true
        )
            LanguageSelectionCircle(
            selected = false
        )
    }
}
}