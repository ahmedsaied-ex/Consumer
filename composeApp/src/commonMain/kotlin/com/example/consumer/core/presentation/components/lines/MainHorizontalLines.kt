package com.example.consumer.core.presentation.components.lines

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors

@Composable
fun HorizontalLine(
    modifier: Modifier = Modifier
) {
    HorizontalDivider(modifier = modifier,color = MaterialTheme.colorScheme.extendedColors.onDisablePrimaryLight)
}

@Composable
@Preview(showBackground=true , locale = "ar")
fun HorizontalLinesPreview() {
    Column(Modifier.padding(DesignSystem.Padding.Padding2XL)){
        ConsumerTheme {
        HorizontalLine()
    }
}
}