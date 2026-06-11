package com.example.consumer.core.presentation.components.mission

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle1
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import com.example.consumer.features.profile.presentation.components.ProfilePictureOrInitials

enum class MissionStatus {
    STARTER,
    SURVEY_STARTED,
    SENT_FOR_EVALUATION,
    RE_EVALUATION_NEEDED,
    APPROVED,
}


@Composable
fun MissionLog(
    modifier: Modifier = Modifier,
    missionStatus: MissionStatus
) {

    Row(modifier.fillMaxWidth().padding(horizontal = 16.dp).height(IntrinsicSize.Min)) {
        MissionCirclePart(missionStatus = missionStatus)
        Column(modifier = Modifier.padding(start = 12.dp)
        ) {
            when(missionStatus){
                MissionStatus.STARTER -> {

                }
                else -> {
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
            Text(
                "25 ابريل 2026 - 09:00 ص",
                style = Subtitle3.copy(color = MaterialTheme.colorScheme.extendedColors.darkBlue650)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "تم إرسال المهمة",
                style = Subtitle1.copy(
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
            Spacer(Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                ProfilePictureOrInitials(canPick = false, size = 28.dp, thickness = 0.5.dp)
                Spacer(Modifier.width(8.dp))
                Text("اسم الشخص", style = Subtitle3.copy(MaterialTheme.colorScheme.extendedColors.darkBlue650))
            }
        }
    }
}

@Composable
fun MissionCirclePart(
    modifier: Modifier = Modifier,
    missionStatus: MissionStatus
) {
    when (missionStatus) {
        MissionStatus.STARTER -> {
            Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                MissionCircles(missionStatus = missionStatus)
                Spacer(Modifier.height(4.dp))
                VerticalDivider(
                    color = MaterialTheme.colorScheme.extendedColors.onDisablePrimaryLight,
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }

        else -> {
            Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

                VerticalDivider(
                    color = MaterialTheme.colorScheme.extendedColors.onDisablePrimaryLight,
                    modifier = Modifier.height(24.dp)
                )
                MissionCircles(missionStatus = missionStatus)
                Spacer(Modifier.height(4.dp))
                VerticalDivider(
                    color = MaterialTheme.colorScheme.extendedColors.onDisablePrimaryLight,
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun Preview() {
    Row(
        Modifier.padding(DesignSystem.Padding.Padding2XL),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ConsumerTheme {
            MissionCirclePart(missionStatus = MissionStatus.STARTER)
            MissionCirclePart(missionStatus = MissionStatus.SURVEY_STARTED)
            MissionCirclePart(missionStatus = MissionStatus.SENT_FOR_EVALUATION)
            MissionCirclePart(missionStatus = MissionStatus.RE_EVALUATION_NEEDED)
            MissionCirclePart(missionStatus = MissionStatus.APPROVED)
        }
    }
}


@Composable
@Preview(showBackground = true, locale = "ar")
fun MissionLogPreview() {
    Column(Modifier.padding(DesignSystem.Padding.Padding2XL)) {
        ConsumerTheme {
            MissionLog(missionStatus = MissionStatus.STARTER)
            MissionLog(missionStatus = MissionStatus.SURVEY_STARTED)
            MissionLog(missionStatus = MissionStatus.SENT_FOR_EVALUATION)
            MissionLog(missionStatus = MissionStatus.RE_EVALUATION_NEEDED)
            MissionLog(missionStatus = MissionStatus.APPROVED)
        }
    }
}