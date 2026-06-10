package com.example.consumer.features.profile.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ic_camera
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfilePictureOrInitials(
    firstCharsOfName: String = "Ar",
    imageUrl: String? = null,
    selectedImageBytes: ByteArray? = null,
    modifier: Modifier = Modifier,
    isUploadingImage: Boolean = false,
    onImageClick: () -> Unit = {},
) {
    Box(modifier = modifier.height(115.dp)) {
        if (isUploadingImage) {
            Box(
                modifier = Modifier.size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 1.5.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = CircleShape
                    )
                    .background(MaterialTheme.colorScheme.tertiaryContainer),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(30.dp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        } else {
            ProfilePictureOrInitialsCircle(
                firstCharsOfName = firstCharsOfName,
                imageUrl = imageUrl,
                selectedImageBytes = selectedImageBytes,
                modifier = modifier
            )
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .size(36.dp)
                .background(MaterialTheme.colorScheme.extendedColors.profileChangePhotoBackground, CircleShape)
                .clip(CircleShape)
                .clickable { onImageClick() },
            contentAlignment = Alignment.Center
        ) {
            Image(painterResource(Res.drawable.ic_camera), contentDescription = null)
        }
    }
}

@Composable
@Preview
fun ProfilePictureOrInitialsPreview() {
    ConsumerTheme { ProfilePictureOrInitials(isUploadingImage = true) }
}

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
                width = 1.5.dp,
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
@Preview
fun ProfilePictureOrInitialsCirclePreview() {
    ConsumerTheme { ProfilePictureOrInitialsCircle() }
}