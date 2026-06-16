package com.example.consumer.core.presentation.components.mission

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.cards.SelectedCircle
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
    SelectedCircle(modifier = modifier,color = color, thickness = 8, size = 24)
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