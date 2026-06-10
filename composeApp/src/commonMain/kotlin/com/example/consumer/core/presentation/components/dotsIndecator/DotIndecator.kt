package com.example.consumer.core.presentation.components.dotsIndecator

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.dotsIndecator.DotIndicator
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors

@Composable
fun DotIndicator(
    totalDots: Int,
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    spacing: Dp = 8.dp,
    selectedSize: Dp = 8.dp,
    selectedColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    unSelectedColor: Color = MaterialTheme.colorScheme.extendedColors.onDisablePrimaryLight,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing), verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(selectedSize)
                        .clip(CircleShape)
                        .background(selectedColor)
                        ,
                    contentAlignment = Alignment.Center
                ) {}
            } else {
                Box(
                    modifier = Modifier
                        .size(selectedSize)
                        .clip(CircleShape)
                        .background(unSelectedColor)
                    ,
                    contentAlignment = Alignment.Center
                ) {}
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DotIndicatorPreview(){
    ConsumerTheme{
        DotIndicator(
            totalDots = 5,
            selectedIndex = 2
        )
    }
}