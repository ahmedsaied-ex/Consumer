package com.example.consumer.core.presentation.components.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.theme.ConsumerTheme
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.selected_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun SelectedCircularIcon(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.size(20.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Image(
            painterResource(Res.drawable.selected_icon),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun CircularIcon(
    modifier: Modifier = Modifier,
    isSelectable: Boolean = true,
    isSelected: Boolean = false
) {
    if (isSelectable) {
        if (isSelected) {
            SelectedCircularIcon(modifier = modifier)
        } else {
            UnSelectedCircularIcon(modifier = modifier)
        }
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun CircularIconPreview() {
    ConsumerTheme {
        CircularIcon()
    }

}

@Composable
fun UnSelectedCircularIcon(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onPrimary
) {
    Box(
        modifier = modifier.size(20.dp).border(
            width = 1.dp,
            brush = SolidColor(color),
            shape = CircleShape
        )
    )
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun UnSelectedCircularIconPreview() {
    ConsumerTheme {
        UnSelectedCircularIcon()
    }

}

@Composable
@Preview(showBackground = true, locale = "ar")
fun SelectedCircularIconPreview() {
    ConsumerTheme {
        SelectedCircularIcon()
    }

}