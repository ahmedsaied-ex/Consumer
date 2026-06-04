package com.example.consumer.core.presentation.components.mission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors

@Composable
fun MissionStatus(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    backgroundColor: Color
) {
    Box(
        modifier = modifier
            .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(horizontal = 12.dp, vertical = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text, style = Subtitle3.copy(color = textColor, fontWeight = FontWeight.Medium))
    }
}

@Composable
@Preview(showBackground = true)
fun MissionStatusPreview() {
    ConsumerTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
        ) {
            MissionStatus(
                text = "جديدة",
                textColor = MaterialTheme.colorScheme.extendedColors.newMissionTextColor,
                backgroundColor = MaterialTheme.colorScheme.extendedColors.newMissionBackgroundColor
            )
            MissionStatus(
                text = "قيد التنفيذ",
                textColor = MaterialTheme.colorScheme.extendedColors.inProgressMissionTextColor,
                backgroundColor = MaterialTheme.colorScheme.extendedColors.inProgressMissionBackgroundColor
            )
            MissionStatus(
                text = "قيد المراجعة",
                textColor = MaterialTheme.colorScheme.extendedColors.underReviewMissionTextColor,
                backgroundColor = MaterialTheme.colorScheme.extendedColors.underReviewMissionBackgroundColor
            )
            MissionStatus(
                text = "منتهية",
                textColor = MaterialTheme.colorScheme.extendedColors.completedMissionTextColor,
                backgroundColor = MaterialTheme.colorScheme.extendedColors.completedMissionBackgroundColor
            )
            MissionStatus(
                text = "إعادة تقييم",
                textColor = MaterialTheme.colorScheme.extendedColors.reevaluateMissionTextColor,
                backgroundColor = MaterialTheme.colorScheme.extendedColors.reevaluateMissionBackgroundColor
            )
        }
    }

}