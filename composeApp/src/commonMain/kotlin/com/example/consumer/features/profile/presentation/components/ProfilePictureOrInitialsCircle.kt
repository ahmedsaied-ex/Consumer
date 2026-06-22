package com.example.consumer.features.profile.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.theme.ConsumerTheme

@Composable
fun ProfilePictureOrInitialsCircle(
    firstCharsOfName: String = "Ar",
    imageUrl: String? = null,
    selectedImageBytes: ByteArray? = null,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(100.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = CircleShape
            )
            .clip(CircleShape)
    ) {
        when {
            selectedImageBytes != null -> {
                ProfileImage(
                    imageData = selectedImageBytes,
                    firstCharsOfName = firstCharsOfName
                )
            }
            !imageUrl.isNullOrEmpty() -> {
                ProfileImage(
                    imageUrl = imageUrl,
                    firstCharsOfName = firstCharsOfName
                )
            }
            else -> {
                ProfileInitials(firstCharsOfName = firstCharsOfName)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfilePictureOrInitialsCirclePreviewer(){
    ConsumerTheme {
        ProfilePictureOrInitialsCircle()
    }
}