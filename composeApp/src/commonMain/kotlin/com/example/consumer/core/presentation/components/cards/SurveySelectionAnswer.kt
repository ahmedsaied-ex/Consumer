package com.example.consumer.core.presentation.components.cards


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.utils.UnSelectedCircularIcon
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle2
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors

@Composable
fun SurveySelectionAnswer(
    modifier: Modifier = Modifier,
    selected: Boolean,
    text: String
) {
    val surveyBackground =
        if (selected) MaterialTheme.colorScheme.extendedColors.surveySelectedBackground else MaterialTheme.colorScheme.extendedColors.surveyUnSelectedBackground
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(DesignSystem.Radius.RadiusMd))
            .background(surveyBackground)
            .then(
                if (selected) {
                    Modifier.border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.extendedColors.blueSapphire700,
                        shape = RoundedCornerShape(DesignSystem.Radius.RadiusMd)
                    )
                } else {
                    Modifier
                }
            )
    ) {
        Row(
            modifier = Modifier.padding(vertical = 14.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (selected) {
                SelectedCircle(color = MaterialTheme.colorScheme.tertiary)
            } else {
                UnSelectedCircularIcon()
            }
            Spacer(Modifier.width(12.dp))
            Text(text, style = Subtitle2.copy(color = MaterialTheme.colorScheme.onBackground))
        }
    }
}


@Composable
fun SurveyButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    enabled: Boolean,
    onClick: () -> Unit,
    text: String
) {
    val surveyBackground =
        if (selected) {
            if (enabled ){
                MaterialTheme.colorScheme.extendedColors.surveySelectedBackground }
            else{
                Color(0xFFf5f8fa)
            }
        } else {
            if (enabled){ MaterialTheme.colorScheme.extendedColors.surveyUnSelectedBackground }else{
                Color(0xFFfafcfc)
            }
        }

    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        border = if (selected) {
            BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.extendedColors.blueSapphire700
            )
        } else null,
        contentPadding = PaddingValues(vertical = 14.dp, horizontal = 16.dp),
        shape = RoundedCornerShape(DesignSystem.Radius.RadiusMd),
        colors = ButtonDefaults.buttonColors(
            containerColor = surveyBackground,
            contentColor = MaterialTheme.colorScheme.onBackground,
            disabledContainerColor = Color(0xFFfafcfc),
            disabledContentColor =Color(0xFF8d8ea1)
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (selected) {
                SelectedCircle(color = MaterialTheme.colorScheme.tertiary)
            } else {
                UnSelectedCircularIcon(color = MaterialTheme.colorScheme.extendedColors.darkBlue450)
            }
            Spacer(Modifier.width(12.dp))
            Text(text, style = Subtitle2.copy(color =Color(0xFF8d8ea1)))
        }

    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun SurveyButtonPreview() {
    ConsumerTheme {
        Column(
            Modifier.padding(DesignSystem.Padding.Padding2XL),
            verticalArrangement = Arrangement.spacedBy(
                DesignSystem.Padding.Padding2XL
            )
        ) {
            SurveyButton(
                selected = false,
                enabled = false,
                onClick = { },
                text = "5"
            )

            SurveyButton(
                selected = false,
                enabled = true,
                onClick = { },
                text = "5"
            )

            SurveyButton(
                selected = false,
                enabled = true,
                onClick = { },
                text = "5"
            )

            SurveyButton(
                selected = false,
                enabled = true,
                onClick = { },
                text = "5"
            )

        }
    }
}


@Composable
fun SelectedCircle(
    modifier: Modifier = Modifier, color: Color, size: Int = 18, thickness: Int = 6
) {
    Box(
        modifier = modifier.clip(shape = RoundedCornerShape(12.dp))
            .size(size.dp).border(
                width = thickness.dp,
                brush = SolidColor(color),
                shape = CircleShape
            ),
    )
}


@Composable
@Preview(showBackground = true, locale = "ar")
fun SelectedDotPreview() {
    Column(
        Modifier.padding(DesignSystem.Padding.Padding2XL),
        verticalArrangement = Arrangement.spacedBy(
            DesignSystem.Padding.Padding2XL
        )
    ) {
        ConsumerTheme {
            SelectedCircle(color = MaterialTheme.colorScheme.tertiary)
        }
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun SurveySelectionAnswerPreview() {
    ConsumerTheme {
        Column(
            Modifier.padding(DesignSystem.Padding.Padding2XL),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SurveySelectionAnswer(text = "5", selected = true)
            SurveySelectionAnswer(text = "نعم", selected = false)
        }
    }
}
