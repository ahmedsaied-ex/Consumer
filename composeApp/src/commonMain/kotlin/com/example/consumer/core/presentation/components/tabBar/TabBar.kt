package com.example.consumer.core.presentation.components.tabBar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.foundation.DesignSystem.DesignSystem
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ambassador
import consumer.composeapp.generated.resources.consumer
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

data class TabItem(
    val id: String,
    val title: StringResource,
)

@Composable
fun TabBar(
    modifier: Modifier = Modifier,
    tabs: List<TabItem>,
    selectedTabId: String,
    onTabSelected: (TabItem) -> Unit
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
                modifier = Modifier.weight(1f),
                text = stringResource(tab.title),
                selected = tab.id == selectedTabId,
                onClick = { onTabSelected(tab) }
            )
        }
    }
}


@Composable
@Preview(showBackground = false)
fun TabBarPreview1Tab() {
    ConsumerTheme {
        TabBar(
            tabs = listOf(TabItem(id = "1", title = Res.string.consumer)),
            selectedTabId = "1",
            onTabSelected = {},
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TabBarPreview2Tabs() {
    ConsumerTheme {
        TabBar(
            tabs = listOf(TabItem(id = "1", title = Res.string.consumer), TabItem(id = "2", title = Res.string.ambassador)),
            selectedTabId = "2",
            onTabSelected = {},
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TabBarPreview3tabs() {
    ConsumerTheme {
        TabBar(
            tabs = listOf(
                TabItem(id = "1", title = Res.string.consumer),
                TabItem(id = "2", title = Res.string.ambassador),
                TabItem(id = "3", title = Res.string.consumer)
            ),
            selectedTabId = "1",
            onTabSelected = {},
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TabBarPreview4tab() {
    ConsumerTheme {
        TabBar(
            tabs = listOf(
                TabItem(id = "1", title = Res.string.consumer),
                TabItem(id = "2", title = Res.string.ambassador),
                TabItem(id = "3", title = Res.string.consumer),
                TabItem(id = "4", title = Res.string.ambassador)
            ),
            selectedTabId = "1",
            onTabSelected = {},
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
    val durationTime = 400
    val backgroundColor by animateColorAsState(
        targetValue = if (selected) {
            MaterialTheme.colorScheme.tertiary
        } else {
            MaterialTheme.colorScheme.extendedColors.tabUnselectedBackgroundColor
        },
        animationSpec = tween(
            durationMillis = durationTime,
            easing = FastOutSlowInEasing
        ),
        label = "tab_background"
    )

    val textColor by animateColorAsState(
        targetValue = if (selected) {
            MaterialTheme.colorScheme.onTertiary
        } else {
            MaterialTheme.colorScheme.onBackground
        },
        animationSpec = tween(
            durationMillis = durationTime,
            easing = FastOutSlowInEasing
        ),
        label = "tab_text"
    )

    val scale by animateFloatAsState(
        targetValue = if (selected) 1f else 0.96f,
        animationSpec = tween(
            durationMillis = durationTime,
            easing = FastOutSlowInEasing
        ),
        label = "tab_scale"
    )
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleSmall.copy(
            fontWeight = FontWeight.Medium,
            color=textColor
        ),
        modifier = modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .clip(RoundedCornerShape(DesignSystem.Radius.RadiusMd))
            .background(
                backgroundColor
            )
            .padding(
                vertical = DesignSystem.Padding.Padding2xs,
                horizontal = DesignSystem.Padding.Padding1xs
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
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