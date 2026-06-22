package com.example.consumer.features.profile.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.H5
import com.example.consumer.core.presentation.theme.ConsumerTheme

@Composable
fun ProfileTopPart(
    modifier: Modifier = Modifier,
    name: String,
    initials: String,
    imageUrl: String,
    selectedImageBytes: ByteArray? = null,
    isUploadingImage: Boolean = false,
    onImageClick: () -> Unit = {}
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        ProfilePictureOrInitials(
            imageUrl = imageUrl,
            selectedImageBytes = selectedImageBytes,
            isUploadingImage = isUploadingImage,
            onImageClick = onImageClick,
            initials = initials
        )
        Spacer(Modifier.height(16.dp))
        Text(
            name,
            style = H5.copy(
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun ProfileTopPartPreview() {
    ConsumerTheme {
            ProfileTopPart(
                name = "عمرو عبد الله",
                imageUrl = "",
                selectedImageBytes = null,
                isUploadingImage = false,
                onImageClick = {},
                initials = "AR"
            )
    }

}