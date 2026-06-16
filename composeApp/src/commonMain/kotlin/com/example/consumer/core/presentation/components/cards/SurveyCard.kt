package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle2
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.questions
import org.jetbrains.compose.resources.stringResource

@Composable
fun SurveyCard(
    modifier: Modifier = Modifier,
    title: String,
    numberOfQuestions: Int,
    startDate: String,
    endDate: String
) {
    ConsumerCostumeCard(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            GreenSideBar(modifier = Modifier.padding(vertical = 14.dp))

            Column(modifier = Modifier.padding(DesignSystem.Padding.Padding2XL)) {
                Text(
                    title,
                    style = Subtitle2.copy(
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                )
                Spacer(Modifier.height(2.dp))
                Row {
                    Text(
                        numberOfQuestions.toString(),
                        style = Subtitle3.copy(
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(
                        stringResource(Res.string.questions),
                        style = Subtitle3.copy(
                            color = MaterialTheme.colorScheme.extendedColors.darkBlue650
                        )
                    )

                }
                Spacer(Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        startDate,
                        style = Subtitle3.copy(
                            color = MaterialTheme.colorScheme.extendedColors.darkBlue650
                        )
                    )
                    Box(
                        modifier = Modifier.size(4.dp).clip(CircleShape)
                            .background(MaterialTheme.colorScheme.extendedColors.onDisablePrimaryLight)
                    )
                    Text(
                        endDate,
                        style = Subtitle3.copy(
                            color = MaterialTheme.colorScheme.extendedColors.darkBlue650
                        )
                    )
                }
            }
        }
    }
}


@Composable
fun GreenSideBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxHeight().width(3.dp).clip(
            RoundedCornerShape(topEnd = 40.dp)
        ).clip(
            RoundedCornerShape(bottomEnd = 40.dp)
        ).background(MaterialTheme.colorScheme.onPrimaryContainer)
    )
}

@Composable
@Preview(showBackground = true, locale = "ar", heightDp = 100)
fun GreenSideBarPreview() {
    ConsumerTheme {
        GreenSideBar()
    }

}

@Composable
@Preview(showBackground = true, locale = "ar")
fun SurveyCardPreview() {
    ConsumerTheme {
        Box(Modifier.padding(16.dp)) {
            SurveyCard(
                title = "قياس رضا المستهلكين عن سرعة معالجة الشكاوى",
                numberOfQuestions = 10,
                startDate = "20 مايو 2026",
                endDate = "30 مايو 2026"
            )
        }
    }

}