package com.example.consumer.core.presentation.foundation.DesignSystem

import androidx.compose.ui.unit.Dp



/**
 * POC Design System
 *
 * Central access point for all design system components and tokens.
 * This provides a clean API for consuming design system elements.
 *
 * Usage Examples:
 * ```kotlin
 * import com.auctionex.expertapps.shared.ui.DesignSystem
 *
 * // Use colors in your composables
 * Card(
 *     colors = CardDefaults.cardColors(
 *         containerColor = DesignSystem.Colors.Primary
 *     )
 * )
 *
 * // Use spacing
 * Column(
 *     modifier = Modifier.padding(DesignSystem.Spacing.Medium)
 * )
 * ```
 */
object DesignSystem {
    /**
     * Spacing system - consistent spacing values
     */
    object Padding {
        val None: Dp = ConsumerDimensions.padding.none
        val Padding2xs: Dp = ConsumerDimensions.padding.padding2xs
        val Padding1xs: Dp = ConsumerDimensions.padding.padding1xs
        val PaddingSm: Dp = ConsumerDimensions.padding.paddingSm
        val PaddingMd: Dp = ConsumerDimensions.padding.paddingMd
        val PaddingL: Dp = ConsumerDimensions.padding.paddingLg
        val PaddingXL: Dp = ConsumerDimensions.padding.paddingXl
        val Padding2XL: Dp = ConsumerDimensions.padding.padding2xl
        val Padding3XL: Dp = ConsumerDimensions.padding.padding3xl
        val Padding4XL: Dp = ConsumerDimensions.padding.padding4xl
        val Padding5XLe: Dp = ConsumerDimensions.padding.padding5xl
        val Padding6XL: Dp = ConsumerDimensions.padding.padding6xl

    }

    object Radius {
        val Radius2xs: Dp = ConsumerDimensions.radius.radius2xs
        val Radius1xs: Dp = ConsumerDimensions.radius.radius1xs
        val RadiusSm: Dp = ConsumerDimensions.radius.radiusSm
        val RadiusMd: Dp = ConsumerDimensions.radius.radiusMd
        val RadiusLg: Dp = ConsumerDimensions.radius.radiusLg
        val RadiusXL: Dp = ConsumerDimensions.radius.radiusXl
        val Radius2XL: Dp = ConsumerDimensions.radius.radius2xl
        val Radius3XL: Dp = ConsumerDimensions.radius.radius3xl
        val Radius4XL: Dp = ConsumerDimensions.radius.radius4xl
        val Radius5XL: Dp = ConsumerDimensions.radius.radius5xl
        val Radius6XL: Dp = ConsumerDimensions.radius.radius6xl
    }

    object Shadow{
        val DialogShadow = ConsumerDimensions.dropShadow.DialogShadow
    }





}
