@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.consumer.core.presentation.components

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

@Composable
fun CostumeBottomSheet(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    val sheetState =rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    LaunchedEffect(sheetState) {
        if (sheetState.isVisible) {
            sheetState.expand()
        }
    }
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        modifier = modifier.systemBarsPadding(),
        contentWindowInsets = { WindowInsets() },
        ){
        content()
    }
}