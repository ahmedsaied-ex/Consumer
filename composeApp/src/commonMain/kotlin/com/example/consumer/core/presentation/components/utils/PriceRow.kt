package com.example.consumer.core.presentation.components.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.domain.utils.formatWithCommasDefault
import com.example.consumer.core.presentation.foundation.typography.H5
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.saudi_riyal_symbol
import org.jetbrains.compose.resources.painterResource

@Composable
fun PriceRow(
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Bold,
    color: Color = MaterialTheme.colorScheme.extendedColors.blueSapphire700,
    style: TextStyle = H5.copy(color = color, fontWeight = fontWeight),
    symbolHeight: Double = 22.5,
    symbolWidth: Int = 25,
    value: Any
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(formatWithCommasDefault(value.toString()), style = style)
        Spacer(modifier = Modifier.width(6.dp))
        Image(
            painterResource(Res.drawable.saudi_riyal_symbol),
            contentDescription = null,
            modifier = Modifier.height(symbolHeight.dp).width(symbolWidth.dp)
        )
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun PriceRowPreview() {
    ConsumerTheme {
        PriceRow(value = 100)
    }

}
