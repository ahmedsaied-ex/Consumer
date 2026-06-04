package com.auctionex.expertapps.ui.foundation.shapes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Material Design 3 Shape System
 * Consistent corner radius values for components
 */
internal val AuctionExShapes =
    Shapes(
        extraSmall = RoundedCornerShape(4.dp), // Small components like chips
        small = RoundedCornerShape(10.dp),
        medium = RoundedCornerShape(12.dp), // Cards, dialogs
        large = RoundedCornerShape(16.dp), // Large cards, bottom sheets
        extraLarge = RoundedCornerShape(28.dp), // Very large components
    )



/**
 * Additional custom shapes for specific use cases
 */
object AuctionExCustomShapes {
    val none = RoundedCornerShape(0.dp)
    val medium = RoundedCornerShape(8.dp)
    val circular = RoundedCornerShape(50)
val extraMedium = RoundedCornerShape(10.dp) // Buttons, text fields

    // Financial card shapes
    val coinCard = RoundedCornerShape(12.dp)
    val portfolioCard = RoundedCornerShape(16.dp)
    val chartContainer = RoundedCornerShape(8.dp)

    // Navigation shapes
    val bottomSheet =
        RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp,
        )
    val onBoardingBox =
        RoundedCornerShape(
            bottomStart = 10.dp,
            bottomEnd = 10.dp,
        )
    val dialog = RoundedCornerShape(24.dp)

    // Button variations
    val buttonSmall = RoundedCornerShape(6.dp)
    val buttonMedium = RoundedCornerShape(8.dp)
    val buttonLarge = RoundedCornerShape(12.dp)
    val buttonPill = RoundedCornerShape(50)

    // Input field shapes
    val textField = RoundedCornerShape(
        topStart = 4.dp,
        topEnd = 4.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp,
    )
    val searchField = RoundedCornerShape(24.dp)

    // Image shapes
    val avatar = RoundedCornerShape(50)
    val thumbnail = RoundedCornerShape(8.dp)
    val banner = RoundedCornerShape(12.dp)
}
