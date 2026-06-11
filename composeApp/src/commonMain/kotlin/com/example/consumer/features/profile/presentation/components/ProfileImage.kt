package com.example.consumer.features.profile.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.consumer.core.presentation.foundation.typography.H1
import com.example.consumer.core.presentation.foundation.typography.H4
import com.example.consumer.core.presentation.foundation.typography.H5
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ic_camera
import consumer.composeapp.generated.resources.ic_profile_active
import consumer.composeapp.generated.resources.profile_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileImage(
    imageUrl: String? = null,
    imageData: ByteArray? = null,
    iconWidth: Dp = 28.dp,
    iconHeight: Dp = 28.dp,
    modifier: Modifier = Modifier,
    size: Dp,
    thickness: Dp=1.5.dp
) {
    var imageLoadFailed by remember { mutableStateOf(false) }

    if (imageLoadFailed) {
        // Show initials if image failed to load
        ProfileInitials(
            iconWidth = iconWidth,
            iconHeight = iconHeight,
            size = size,
            thickness = thickness
        )
    } else {
        AsyncImage(
            model = imageData ?: imageUrl,
            contentDescription = "Profile picture",
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize(),
            placeholder = painterResource(Res.drawable.ic_profile_active),
            onError = {
                imageLoadFailed = true
            }
        )
    }
}

@Composable
@Preview(showBackground=true)
fun ProfileImagePreview() {
    ConsumerTheme {
        ProfileImage(size = 100.dp)
    }

}

@Composable
fun ProfileInitials(
    iconWidth: Dp = 28.dp,
    iconHeight: Dp = 28.dp,
    modifier: Modifier = Modifier,
    size : Dp,
    thickness : Dp =1.5.dp
) {
    Box( contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
            .border(
                width = thickness,
                color = MaterialTheme.colorScheme.outline,
                shape = CircleShape
            )
            .background(
                MaterialTheme.colorScheme.extendedColors.tabBarColorTabsBackground,
                CircleShape
            )){
        Image(
            painter = painterResource(Res.drawable.profile_icon),
            contentDescription = null,
            modifier = Modifier.size(
                width = iconWidth,
                height = iconHeight
            )
        )
    }
}
