package com.example.consumer.features.profile.presentation.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.cards.SelectedCircle
import com.example.consumer.core.presentation.components.utils.UnSelectedCircularIcon
import com.example.consumer.core.presentation.foundation.typography.Subtitle1
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors


@Composable
fun LanguageItemRow(title: String, selected: Boolean, onClick: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth().height(56.dp)
            .clip(RoundedCornerShape(25.dp))
            .clickable { onClick() }
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Crossfade(
            targetState = selected,
            animationSpec = tween(durationMillis = 500),
            label = "languageCircleFade"
        ) { isSelected ->
            if (isSelected) {
                SelectedCircle(color = MaterialTheme.colorScheme.tertiary)
            } else {
                UnSelectedCircularIcon(
                    color = MaterialTheme.colorScheme.extendedColors.darkBlue450,
                    size = 18
                )
            }
        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = title,
            color =  MaterialTheme.colorScheme.onBackground ,
            style = Subtitle1
        )
    }
}
@Composable
@Preview(showBackground = true)
fun LanguageItemRowPreviewer(){
    ConsumerTheme {

        Column{
            LanguageItemRow(title = "English", selected = true, onClick = {})
            LanguageItemRow(title = "Arabic", selected = false, onClick = {})
        }
    }
}