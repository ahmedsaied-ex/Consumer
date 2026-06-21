package com.example.consumer.core.presentation.components

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
@Composable
expect  fun CostumeScaffold(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState= SnackbarHostState(),
    topBar: @Composable () -> Unit={},
    content: @Composable () -> Unit
)