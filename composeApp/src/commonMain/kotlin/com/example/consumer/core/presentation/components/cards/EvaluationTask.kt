package com.example.consumer.core.presentation.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.utils.AsyncImageProduct
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Subtitle1
import com.example.consumer.core.presentation.foundation.typography.Subtitle3
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.branch
import consumer.composeapp.generated.resources.evaluation_calender
import consumer.composeapp.generated.resources.ic_pin
import consumer.composeapp.generated.resources.ic_sector
import consumer.composeapp.generated.resources.implementation_date
import consumer.composeapp.generated.resources.sector
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EvaluationTasks(
    modifier: Modifier = Modifier,
    marketName: String,
    marketLocation: String,
    sector:String,
    date: String
) {
    ConsumerCostumeCard(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp , horizontal = 20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(
                    marketName,
                    style = Subtitle1.copy(
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                )
                Spacer(Modifier.height(8.dp))
                EvaluationTaskDataRow(
                    rowTitle = stringResource(Res.string.branch),
                    rowDescription = marketLocation,
                    icon = Res.drawable.ic_pin,
                )
                Spacer(Modifier.height(4.dp))
                EvaluationTaskDataRow(
                    rowTitle = stringResource(Res.string.sector),
                    rowDescription = sector,
                    icon = Res.drawable.ic_sector,
                )
                Spacer(Modifier.height(4.dp))
                EvaluationTaskDataRow(
                    rowTitle = stringResource(Res.string.implementation_date),
                    rowDescription = date,
                    icon = Res.drawable.evaluation_calender,
                )
            }
            AsyncImageProduct(size = 80, imageUrl = "", modifier = Modifier.padding(top = 4.dp))
        }
    }
}

@Composable
fun EvaluationTaskDataRow(
    modifier: Modifier = Modifier,
    rowTitle: String,
    rowDescription: String,
    icon: DrawableResource
) {
    Row(modifier=modifier,verticalAlignment = Alignment.CenterVertically) {
        Image(painterResource(icon), contentDescription = null)
        Spacer(Modifier.width(8.dp))
        Text(
           rowTitle,
            style = Subtitle3.copy(color = MaterialTheme.colorScheme.extendedColors.darkBlue650)
        )
        Spacer(Modifier.width(4.dp))
        Text(
            rowDescription,
            style = Subtitle3.copy(
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Composable
@Preview(showBackground=true , locale = "ar")
fun EvaluationTaskDataRowPreview() {
    Column(Modifier.padding(DesignSystem.Padding.Padding2XL)){
        ConsumerTheme {
        EvaluationTaskDataRow(
            rowTitle = "فرع",
            rowDescription = "بانوراما مول - الرياض",
            icon = Res.drawable.ic_pin,
        )
    }
}
}
@Composable
@Preview(showBackground = true, locale = "ar")
fun EvaluationTasksPreview() {
    Column(Modifier.padding(DesignSystem.Padding.Padding2XL)) {
        ConsumerTheme {
            EvaluationTasks(
                marketName = "متجر بنده",
                marketLocation = "بانوراما مول - الرياض",
                sector = "المواد الغذائية والسلع الاستهلاكية",
                date = "10 مايو 2026"
            )
        }
    }
}