package com.example.consumer.core.presentation.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.DesignSystem.ConsumerDimensions
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.foundation.typography.Button1
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.group
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

enum class ButtonSize {
    SMALL, MEDIUM, LARGE, ;

    fun toHeight(): Dp = when (this) {
        SMALL -> 40.dp
        MEDIUM -> 45.dp
        LARGE -> 50.dp
    }

    fun toVerticalPadding(): Dp = when (this) {
        SMALL -> DesignSystem.Padding.Padding1xs
        MEDIUM -> DesignSystem.Padding.PaddingSm
        LARGE -> DesignSystem.Padding.PaddingMd
    }
}

@Composable
fun ConsumerFilledButton(
    isLoading: Boolean = false,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    type: ButtonsTypes = ButtonsTypes.PRIMARY,
    backgroundColor: Color? = null,
    textColor: Color? = null,
    corner: Dp = ConsumerDimensions.Radius.radiusMd,
    size: ButtonSize = ButtonSize.LARGE,
    fontStyle: TextStyle = Button1.copy(fontWeight = FontWeight.SemiBold),
    contentPadding: PaddingValues = PaddingValues(
        horizontal = DesignSystem.Padding.PaddingL,
        vertical = size.toVerticalPadding(),
    ),
) {
    val features = type.getFeatures()

    val containerColor = backgroundColor ?: if (enabled) {
        features.containerColor
    } else {
        features.disabledContainerColor
    }

    val contentColor = textColor ?: if (enabled) {
        features.contentColor
    } else {
        features.disabledContentColor
    }

    Button(
        onClick = onClick,
        modifier = modifier.height(size.toHeight()),
        enabled = if (isLoading) false else enabled,
        shape = RoundedCornerShape(corner),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor,
            disabledContentColor = contentColor,
        ),
        contentPadding = contentPadding,
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = contentColor
            )
        } else {
            Text(
                text = text,
                style = fontStyle,
            )
        }
    }
}


@Composable
fun ConsumerBorderTransparentButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    corner: Dp = ConsumerDimensions.Radius.radiusMd,
    fontStyle: TextStyle = Button1.copy(fontWeight = FontWeight.SemiBold),
    size: ButtonSize = ButtonSize.LARGE,
    contentColor: Color = MaterialTheme.colorScheme.tertiary,
    disabledColor: Color = MaterialTheme.colorScheme.secondaryContainer
) {
    val currentColor = if (enabled) contentColor else disabledColor

    Button(
        onClick = onClick,
        modifier = modifier.height(size.toHeight()),
        enabled = enabled,
        shape = RoundedCornerShape(corner),
        border = BorderStroke(1.dp, currentColor),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Transparent,
            contentColor = contentColor,
            disabledContentColor = disabledColor,
        ),
        contentPadding = PaddingValues(
            horizontal = DesignSystem.Padding.PaddingMd,
            vertical = DesignSystem.Padding.PaddingSm,
        ),
    ) {
        Text(
            text = text,
            style = fontStyle,
        )
    }
}

@Composable
fun ConsumerBorderIconButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier, iconRes: DrawableResource? = null,
    enabled: Boolean = true,
    corner: Dp = ConsumerDimensions.Radius.radiusMd,
    fontStyle: TextStyle = Button1.copy(fontWeight = FontWeight.SemiBold),
    size: ButtonSize = ButtonSize.LARGE,
    borderColor: Color = MaterialTheme.colorScheme.extendedColors.buttonBorderColorAuth,
    textColor: Color = MaterialTheme.colorScheme.tertiary,
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(size.toHeight()),
        enabled = enabled,
        shape = RoundedCornerShape(corner),
        border = BorderStroke(1.dp, borderColor),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor,

        ),
        contentPadding = PaddingValues(
            horizontal = DesignSystem.Padding.PaddingMd,
            vertical = DesignSystem.Padding.PaddingSm,
        ),
    ) {
        if (iconRes == null) {
            Text(
                text = text,
                style = fontStyle,
            )
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {

                    Text(
                        text = text,
                        style = fontStyle,
                    )
                    Spacer(modifier = Modifier.width(16.dp))

                    Image(
                        painter = painterResource(iconRes),
                        contentDescription = null,
                    )





            }
        }
    }
}

@Composable
fun ConsumerTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textColor: Color? = null,
    fontStyle: TextStyle = Button1.copy(fontWeight = FontWeight.SemiBold),
    size: ButtonSize = ButtonSize.LARGE,
    corner: Dp = ConsumerDimensions.Radius.radiusMd,
) {
    val contentColor = textColor ?: if (enabled) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.secondaryContainer
    }
    Button(
        onClick = onClick,
        modifier = modifier.height(size.toHeight()),
        enabled = enabled,
        shape = RoundedCornerShape(corner),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Transparent,
        ),
        contentPadding = PaddingValues(
            horizontal = DesignSystem.Padding.PaddingMd,
            vertical = DesignSystem.Padding.PaddingSm,
        ),
    ) {
        Text(
            text = text,
            style = fontStyle,
            color = contentColor

        )
    }
}

@Preview(name = "Buttons Preview", showBackground = true, heightDp = 1000, locale = "ar")
@Composable
private fun ConsumerButtonsPreview() {
    ConsumerTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            ConsumerFilledButton(
                text = "اضغط هنا",
                type = ButtonsTypes.PRIMARY,
                enabled = true,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )
            ConsumerFilledButton(
                text = "اضغط هنا",
                type = ButtonsTypes.PRIMARY,
                enabled = false,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )

            ConsumerFilledButton(
                text = "اضغط هنا",
                enabled = true,
                type = ButtonsTypes.SECONDARY,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )

            ConsumerFilledButton(
                text = "اضغط هنا",
                enabled = false,
                type = ButtonsTypes.SECONDARY,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )
            ConsumerFilledButton(
                text = "اضغط هنا",
                type = ButtonsTypes.TERTIARY,
                enabled = true,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )
            ConsumerFilledButton(
                text = "اضغط هنا",
                type = ButtonsTypes.TERTIARY,
                enabled = false,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )

            ConsumerFilledButton(
                text = "اضغط هنا",
                enabled = true,
                type = ButtonsTypes.DESTRUCTIVE,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )
            ConsumerFilledButton(
                text = "اضغط هنا",
                enabled = false,
                type = ButtonsTypes.DESTRUCTIVE,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )

            ConsumerTextButton(
                text = "اضغط هنا",
                onClick = {},
                enabled = true,
                modifier = Modifier.fillMaxWidth(),
            )
            ConsumerTextButton(
                text = "اضغط هنا",
                onClick = {},
                enabled = false,
                modifier = Modifier.fillMaxWidth(),
            )
            ConsumerBorderTransparentButton(
                text = "اضغط هنا",
                onClick = {},
                enabled = true,
                modifier = Modifier.fillMaxWidth(),
            )
            ConsumerBorderTransparentButton(
                text = "اضغط هنا",
                onClick = {},
                enabled = false,
                modifier = Modifier.fillMaxWidth(),
            )
            ConsumerBorderIconButton(
                text = "اضغط هنا",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                iconRes = Res.drawable.group
            )

        }
    }
}
