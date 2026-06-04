package com.example.consumer.core.presentation.components.mission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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
    color: Color
) {
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
                .size(8.dp)
        ){}
    }
}

@Composable
@Preview(showBackground = true)
fun MissionCirclesPreview() {
    ConsumerTheme {
        MissionCircles(color = MaterialTheme.colorScheme.extendedColors.reevaluateMissionTextColor)
    }

}