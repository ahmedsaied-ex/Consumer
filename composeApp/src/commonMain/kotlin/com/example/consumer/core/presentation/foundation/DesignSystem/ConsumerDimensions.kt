package com.example.consumer.core.presentation.foundation.DesignSystem

import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

/**
 * Design System Dimensions
 * Consistent spacing and sizing values for the entire app
 */
object ConsumerDimensions {
    val baseUnit = 8.dp
    val padding = Padding
    val radius = Radius
    val dropShadow = DropShadow
    object Padding {
        val none = 0.dp
        val padding2xs = 2.dp
        val padding1xs = 4.dp
        val paddingSm = 6.dp
        val paddingMd = 8.dp
        val paddingLg = 10.dp
        val paddingXl = 12.dp
        val padding2xl = 16.dp
        val padding3xl = 20.dp
        val padding4xl = 24.dp
        val padding5xl = 28.dp
        val padding6xl = 32.dp

    }

    object Radius {
        val radius2xs = 2.dp
        val radius1xs = 4.dp
        val radiusSm = 6.dp
        val radiusMd = 8.dp
        val radiusLg= 10.dp
        val radiusXl = 12.dp
        val radius2xl = 16.dp
        val radius3xl = 20.dp
        val radius4xl = 24.dp
        val radius5xl = 28.dp
        val radius6xl = 32.dp
        val radiusRound = 100.dp




    }

    object DropShadow{
        val DialogShadow =Shadow(
            radius = DesignSystem.Radius.Radius6XL,
            spread = DesignSystem.Radius.RadiusMd,
            offset =  DpOffset(x = 0.dp, y = 0.dp),
            color = Black,
        )
    }
}


