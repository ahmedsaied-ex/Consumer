package com.example.consumer.features.languageSelection.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.colors.SelectedLanguageItemBackground
import com.example.consumer.core.presentation.foundation.colors.UnSelectedLanguageItemBackground
import com.example.consumer.core.presentation.foundation.typography.Button1


@Composable
fun LanguageItem(title: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(DesignSystem.Radius.RadiusMd))
            .background(
                if (selected) SelectedLanguageItemBackground
                else UnSelectedLanguageItemBackground
            )
            .clickable { onClick() }
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            color = if (selected) Color.White else MaterialTheme.colorScheme.primary,
            style = Button1.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.width(6.dp))

        RadioIndicator(selected = selected, borderColor = SelectedLanguageItemBackground)
//        RadioButton(
//            selected = selected,
//            onClick = null,
//            colors = RadioButtonDefaults.colors(
//                selectedColor = MaterialTheme.colorScheme.primary,
//                unselectedColor = Color.White
//            )
//        )

    }
}
