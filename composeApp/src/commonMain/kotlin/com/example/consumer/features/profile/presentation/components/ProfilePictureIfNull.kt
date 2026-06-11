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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ic_camera
import org.jetbrains.compose.resources.painterResource
@Composable
fun ProfilePictureOrInitials(
    imageUrl: String? = null,
    selectedImageBytes: ByteArray? = null,
    modifier: Modifier = Modifier,
    size: Dp = 100.dp,
    isUploadingImage: Boolean = false,
    onImageClick: () -> Unit = {},
    canPick: Boolean = true,
    thickness: Dp =1.5.dp

) {
    val iconWidthRatio = 7.62f / 10f   // 0.2721
    val iconHeightRatio = 10f / 10f    // 0.3571


    val pickerSize = size * 0.36f
    val containerHeight = if (canPick) {
        size + pickerSize / 2
    } else {
        size
    }
    val iconWidth = pickerSize * iconWidthRatio
    val iconHeight = pickerSize * iconHeightRatio
    Box(
        modifier = modifier.height(containerHeight)
    ) {
        if (isUploadingImage) {
            Box(
                modifier = Modifier
                    .size(size)
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
                    modifier = Modifier.size(size * 0.3f),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        } else {
            ProfilePictureOrInitialsCircle(
                thickness = thickness,
                imageUrl = imageUrl,
                iconWidth = iconWidth,
                iconHeight=iconHeight,
                selectedImageBytes = selectedImageBytes,
                modifier = Modifier.size(size)
            )
        }

        if (canPick) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .size(pickerSize)
                    .background(
                        MaterialTheme.colorScheme.extendedColors.profileChangePhotoBackground,
                        CircleShape
                    )
                    .clickable(onClick = onImageClick),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_camera),
                    contentDescription = null,
                    modifier = Modifier.size(pickerSize * 0.5f)
                )
            }
        }
    }
}

@Composable
@Preview
fun ProfilePictureOrInitialsPreview() {
    ConsumerTheme { ProfilePictureOrInitials(isUploadingImage = false, size = 30.dp) }
}

@Composable
fun ProfilePictureOrInitialsCircle(
    imageUrl: String? = null,
    iconWidth: Dp ,
    iconHeight: Dp ,
    selectedImageBytes: ByteArray? = null,
    modifier: Modifier = Modifier,
    size: Dp = 100.dp,
    thickness: Dp =1.5.dp
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
            .border(
                width = thickness,
                color = MaterialTheme.colorScheme.outline,
                shape = CircleShape
            )
            .clip(CircleShape)
    ) {
        when {
            selectedImageBytes != null -> {
                ProfileImage(
                    imageData = selectedImageBytes,
                    iconWidth = iconWidth,
                    iconHeight = iconHeight,
                    thickness = thickness,
                    size = size
                )
            }

            !imageUrl.isNullOrEmpty() -> {
                ProfileImage(
                    imageUrl = imageUrl,
                    iconWidth = iconWidth,
                    iconHeight = iconHeight,
                    thickness = thickness,

                    size = size
                )
            }

            else -> {
                ProfileInitials(
                    iconWidth = iconWidth,
                    iconHeight = iconHeight,
                    modifier=modifier,
                    thickness = thickness,

                    size = size
                )
            }
        }
    }
}

@Composable
@Preview
fun ProfilePictureOrInitialsCirclePreview() {
    ConsumerTheme { ProfilePictureOrInitialsCircle(size = 28.dp, iconWidth = 10.dp, iconHeight = 10.dp) }
}