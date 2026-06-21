package com.example.consumer.features.languageSelection.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.colors.SelectedLanguageItemBackground
import com.example.consumer.core.presentation.foundation.colors.UnSelectedIRadioIndicatorBorder

@Composable
fun RadioIndicator(
    selected: Boolean,
    borderColor: Color
) {
    Box(
        modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))
            .border(
                if (selected)0.dp else 1.dp,
                 UnSelectedIRadioIndicatorBorder,
                RoundedCornerShape(12.dp)
            ).background(White)
            .size(17.dp),
        contentAlignment = Alignment.Center
    ) {
        if (selected) {
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(borderColor)
                    .size(5.dp)

            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun RadioIndicatorPreViwer(){
    RadioIndicator(
        selected = false,
        borderColor = SelectedLanguageItemBackground
    )
}