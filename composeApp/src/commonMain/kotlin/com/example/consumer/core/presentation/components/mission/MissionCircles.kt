package com.example.consumer.core.presentation.components.mission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors

@Composable
fun MissionCircles(
    modifier: Modifier = Modifier,
    missionStatus: MissionStatus
) {
    val color =when (missionStatus) {
        MissionStatus.STARTER -> MaterialTheme.colorScheme.extendedColors.starterCircleColor
        MissionStatus.SURVEY_STARTED -> MaterialTheme.colorScheme.extendedColors.serveyStartedCircleColor
        MissionStatus.SENT_FOR_EVALUATION -> MaterialTheme.colorScheme.extendedColors.sentForEvaluationCircleColor
        MissionStatus.RE_EVALUATION_NEEDED -> MaterialTheme.colorScheme.extendedColors.reevaluationNeededCircleColor
        MissionStatus.APPROVED -> MaterialTheme.colorScheme.extendedColors.approvedCircleColor
    }
    Box(
        modifier = modifier.clip(shape = RoundedCornerShape(12.dp))
            .background(color)
            .size(24.dp),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(12.dp))
                .background(Color.White)
                .size(9.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MissionCirclesPreview() {
    ConsumerTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ){
            MissionCircles(missionStatus = MissionStatus.STARTER)
            MissionCircles(missionStatus = MissionStatus.SURVEY_STARTED)
            MissionCircles(missionStatus = MissionStatus.SENT_FOR_EVALUATION)
            MissionCircles(missionStatus = MissionStatus.RE_EVALUATION_NEEDED)
            MissionCircles(missionStatus = MissionStatus.APPROVED)
        }
    }

}