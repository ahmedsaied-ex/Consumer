package com.example.consumer.features.profile.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.example.consumer.core.presentation.theme.ConsumerTheme
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ic_profile_active
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileImage(
    imageUrl: String? = null,
    imageData: ByteArray? = null,
    firstCharsOfName: String = "",
    modifier: Modifier = Modifier,
) {
    var imageLoadFailed by remember { mutableStateOf(false) }

    if (imageLoadFailed) {
        // Show initials if image failed to load
        ProfileInitials(firstCharsOfName = firstCharsOfName)
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
        ProfileImage()
    }

}

@Composable
fun ProfileInitials(
    firstCharsOfName: String,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color =  MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        Text(
            text = firstCharsOfName,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
