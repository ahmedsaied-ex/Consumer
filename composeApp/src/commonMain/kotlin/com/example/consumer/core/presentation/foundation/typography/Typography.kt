package com.example.consumer.core.presentation.foundation.typography

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.consumer.core.presentation.components.ConsumerTextField
import com.example.consumer.core.presentation.theme.ConsumerTheme


val H1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 62.sp,
    lineHeight = 92.sp,
)
val H2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 48.sp,
    lineHeight = 72.sp,
)
val H3 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 40.sp,
    lineHeight = 60.sp,
)
val H4 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 32.sp,
    lineHeight = 44.sp,
)
val H5 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 26.sp,
    lineHeight = 36.sp,
)
val H6 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 20.sp,
    lineHeight = 32.sp,
)
val Subtitle1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 18.sp,
    lineHeight = 34.sp,
)
val Subtitle2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 16.sp,
    lineHeight = 28.sp,
)
val Subtitle3 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 14.sp,
    lineHeight = 24.sp,
)
val Body1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 16.sp,
    lineHeight = 32.sp,
)
val Body2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 14.sp,
    lineHeight = 28.sp,
)
val Button1 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 16.sp,
    lineHeight = 24.sp,
)
val Button2 @Composable get() = TextStyle(
    fontFamily = IBMPlexSansArabic,
    fontSize = 14.sp,
    lineHeight = 20.sp,
)

val consumerTypography @Composable get() = Typography(
    displayLarge = H1,
    displayMedium = H2,
    displaySmall =  H3,
    headlineLarge = H4,
    headlineMedium = H5,
    headlineSmall = H6,
    titleLarge = Subtitle1,
    titleMedium = Subtitle2,
    titleSmall = Subtitle3,
    bodyLarge = Body1,
    bodyMedium =Body2,
    bodySmall = Button1,
    labelLarge =Button2,
)

@Preview(showBackground = true)
@Composable
private fun ConsumerTextFieldPreviewColoumn() {
    ConsumerTheme {
        Column(
            verticalArrangement = spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {

            Text("Unfocused")

            ConsumerTextField(
                labelText = "Empty"
            )

            ConsumerTextField(
                initialValue = "Ahmed",
                labelText = "Filled"
            )

            Text("Error")

            ConsumerTextField(
                initialValue = "Ahmed",
                isError = true,
                labelText = "Error"
            )

            Text("Disabled filled")

            ConsumerTextField(
                initialValue = "Ahmed",
                enabled = false,
                labelText =  "Disabled"
            )
            Text("Disabled empty")

            ConsumerTextField(
                initialValue = "",
                enabled = false,
                labelText = "Disabled"
            )
        }
    }
}