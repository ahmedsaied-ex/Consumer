package com.example.consumer.core.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem

@Composable
fun CostumeDialog(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = modifier
                .fillMaxSize(0.92f)
                .clip(RoundedCornerShape(DesignSystem.Radius.Radius6XL))
                .imePadding().dropShadow(
                    shape = RoundedCornerShape(DesignSystem.Radius.Radius6XL),
                    shadow = DesignSystem.Shadow.DialogShadow
                ),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp,
            shadowElevation = 8.dp,
            
            shape = RoundedCornerShape(DesignSystem.Radius.Radius6XL)
        ) {
            content()
        }
    }
}

