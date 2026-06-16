package com.example.consumer.features.completeProfile.presentation.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.colors.UnSelectedIRadioIndicatorGenderBorder
import com.example.consumer.core.presentation.foundation.typography.Button2
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import com.example.consumer.features.languageSelection.presentation.components.RadioIndicator

@Composable
fun GenderCard(
    text: String = "ذكر",
    selected: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .width(67.dp)
            .height(39.dp),
        shape = CircleShape, border = BorderStroke(
            1.dp, if (selected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                UnSelectedIRadioIndicatorGenderBorder
            }
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
                .background(
                    if (selected) {
                        MaterialTheme.colorScheme.primaryContainer
                    } else {
                        White
                    }
                )
                .height(40.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text,
                style = Button2,
                color = if (selected) White else MaterialTheme.colorScheme.extendedColors.OTPBoxBorderColor
            )
            RadioIndicator(
                selected = selected,
                borderColor = MaterialTheme.colorScheme.primaryContainer
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun GenderCardPreview() {
    ConsumerTheme {
        GenderCard()
    }

}