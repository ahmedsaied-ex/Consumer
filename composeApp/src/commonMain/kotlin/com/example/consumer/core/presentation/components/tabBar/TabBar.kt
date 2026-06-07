package com.example.consumer.core.presentation.components.tabBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors


@Composable
fun TabBar(
    modifier: Modifier = Modifier,
    tabs: List<String>,
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    Row(
        modifier
            .clip(RoundedCornerShape(DesignSystem.Radius.RadiusMd))
            .background(
                MaterialTheme.colorScheme.extendedColors.tabBarColorTabsBackground
            )
            .padding(DesignSystem.Padding.Padding1xs),
        horizontalArrangement = spacedBy(1.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEachIndexed { index, tab ->
            TabCard(
                text = tab,
                selected = index == selectedIndex,
                onClick = { onTabSelected(index) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
@Preview(showBackground = false)
fun TabBarPreview1Tab() {
    ConsumerTheme {
        TabBar(
            tabs = listOf("Tab 3"),
            selectedIndex = 0,
            onTabSelected = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TabBarPreview2Tabs() {
    ConsumerTheme {
        TabBar(
            tabs = listOf("Tab 2", "Tab 3"),
            selectedIndex = 0,
            onTabSelected = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TabBarPreview3tabs() {
    ConsumerTheme {
        TabBar(
            tabs = listOf("Tab 1", "Tab 2", "Tab 3"),
            selectedIndex = 0,
            onTabSelected = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TabBarPreview4tab() {
    ConsumerTheme {
        TabBar(
            tabs = listOf("Tab 1", "Tab 2", "Tab 3", "Tab 4"),
            selectedIndex = 0,
            onTabSelected = {}
        )
    }
}

@Composable
fun TabCard(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleSmall.copy(
            fontWeight = FontWeight.Medium,
            color = if (selected) {
                MaterialTheme.colorScheme.onTertiary
            } else {
                MaterialTheme.colorScheme.onBackground
            }
        ),
        modifier = modifier
            .clip(RoundedCornerShape(DesignSystem.Radius.RadiusMd))
            .background(
                if (selected) {
                    MaterialTheme.colorScheme.tertiary
                } else {
                    MaterialTheme.colorScheme.extendedColors.tabUnselectedBackgroundColor
                }
            )
            .padding(vertical = DesignSystem.Padding.Padding2xs, horizontal = DesignSystem.Padding.Padding1xs)
            .clickable(onClick = onClick)
    )
}

@Composable
@Preview(showBackground = false)
fun TabCardUnselectedPreview() {
    ConsumerTheme {
        TabCard(
            text = "علامة",
            selected = false,
            onClick = {}
        )
    }

}

@Composable
@Preview(showBackground = false)
fun TabCardSelectedPreview() {
    ConsumerTheme {
        TabCard(
            text = "علامة",
            selected = true,
            onClick = {}
        )
    }

}