package com.example.consumer.core.presentation.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Responsive(
    modifier: Modifier = Modifier
) {
    ProvideWindowInfo{
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            TestCard()
        }
    }
}

@Composable
@Preview(showBackground = true, heightDp = 1000, widthDp = 400)
fun ResponsivePreviewLongAndSlim() {
    Responsive()
}

@Composable
@Preview(showBackground = true, heightDp = 1000, widthDp = 800)
fun ResponsivePreviewLong() {
    Responsive()
}

@Composable
@Preview(showBackground = true, heightDp = 1000, widthDp = 400)
fun ResponsivePreviewShort() {
    Responsive()
}

@Composable
fun TestCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.width(200.w()).height(150.h()), colors = CardDefaults.cardColors(
            containerColor = Red
        )
    ) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TestCardPreview() {
    ProvideWindowInfo{ TestCard() }
}


object DesignSystem {
    const val DESIGN_WIDTH = 440f
    const val DESIGN_HEIGHT = 956f
}

@Immutable
class AdaptiveScale internal constructor(
    private val widthScale: Float,
    private val heightScale: Float,
    private val fontScale: Float
) {

    fun width(dp: Dp): Dp = dp * widthScale

    fun height(dp: Dp): Dp = dp * heightScale

    fun size(dp: Dp): Dp =
        dp * minOf(widthScale, heightScale)

    fun text(sp: TextUnit): TextUnit =
        sp * fontScale
}

@Immutable
data class WindowInfo(
    val width: Dp,
    val height: Dp,
    val scale: AdaptiveScale
)

val LocalWindowInfo =
    staticCompositionLocalOf<WindowInfo> {
        error("WindowInfo not provided")
    }

@Composable
fun ProvideWindowInfo(
    content: @Composable () -> Unit
) {

    BoxWithConstraints {

        val widthScale =
            maxWidth.value / DesignSystem.DESIGN_WIDTH

        val heightScale =
            maxHeight.value / DesignSystem.DESIGN_HEIGHT

        val fontScale =
            minOf(widthScale, heightScale)

        val info = remember(
            maxWidth,
            maxHeight
        ) {
            WindowInfo(
                width = maxWidth,
                height = maxHeight,
                scale = AdaptiveScale(
                    widthScale,
                    heightScale,
                    fontScale
                )
            )
        }

        CompositionLocalProvider(
            LocalWindowInfo provides info
        ) {
            content()
        }
    }
}

@Composable
fun Int.w(): Dp =
    LocalWindowInfo.current.scale.width(this.dp)

@Composable
fun Int.h(): Dp =
    LocalWindowInfo.current.scale.height(this.dp)

@Composable
fun Int.s(): Dp =
    LocalWindowInfo.current.scale.size(this.dp)

@Composable
fun Int.spScaled(): TextUnit =
    LocalWindowInfo.current.scale.text(this.sp)