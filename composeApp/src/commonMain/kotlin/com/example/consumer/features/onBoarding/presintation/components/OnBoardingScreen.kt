package com.example.consumer.features.onBoarding.presintation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.CostumeScaffold
import com.example.consumer.core.presentation.components.bottomSheets.AuthBottomSheet
import com.example.consumer.core.presentation.components.buttons.ButtonsTypes
import com.example.consumer.core.presentation.components.buttons.ConsumerFilledButton
import com.example.consumer.core.presentation.components.dotsIndecator.DotIndicator
import com.example.consumer.core.presentation.components.tabBar.TabItem
import com.example.consumer.core.presentation.foundation.typography.H4
import com.example.consumer.core.presentation.foundation.typography.Subtitle2
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import com.example.consumer.features.onBoarding.domain.models.AuthTabs
import com.example.consumer.features.onBoarding.domain.models.OnBoardingData
import com.example.consumer.features.onBoarding.presintation.viewModels.OnBoardingViewModel
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.compare_your_bucket_description
import consumer.composeapp.generated.resources.compare_your_bucket_title
import consumer.composeapp.generated.resources.consumer_voice
import consumer.composeapp.generated.resources.illustration_onboarding_my_cart
import consumer.composeapp.generated.resources.illustration_smart_shopping
import consumer.composeapp.generated.resources.shop_smart_description
import consumer.composeapp.generated.resources.shop_smart_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    viewModel: OnBoardingViewModel = koinViewModel()
) {
    val items by viewModel.onBoardingUiState.collectAsState()

    OnBoardingScreenContent(
        modifier = modifier,
        items = items.onBoardingScreens,
        isBottomSheetOpened = items.isBottomSheetOpened,
        tabs = items.tabs,
        selectedTabId =  items.selectedTabId ?: AuthTabs.CONSUMER.name,
        onDismiss = { viewModel.closeBottomSheet() },
        onSelected = { viewModel.onTabSelected(it) },

        onContinueClick = { viewModel.openBottomSheet() }
    )

}

@Composable
fun OnBoardingScreenContent(
    modifier: Modifier = Modifier,
    items: List<OnBoardingData> = emptyList(),
    onContinueClick: () -> Unit,
    isBottomSheetOpened: Boolean = false,
    onDismiss: () -> Unit = {},
    tabs: List<TabItem> = emptyList(),
    onSelected: (TabItem) -> Unit = {},
    selectedTabId: String = AuthTabs.CONSUMER.name
) {
    if (isBottomSheetOpened) {
        AuthBottomSheet(
            onDismiss = onDismiss,
            onTabSelected = onSelected,
            onLoginClick = {},
            onAppleClick = {},
            onGoogleClick = {},
            tabs = tabs,
            selectedTabId = selectedTabId,
        )
    }

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { items.size }
    )

    CostumeScaffold {
        BottomGlow()

        // ✅ Guard against empty state before rendering anything
        if (items.isEmpty()) return@CostumeScaffold

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    stringResource(Res.string.consumer_voice),
                    style = H4.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(82.dp))
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth()
                ) { page ->
                    val item = items[page]
                    Box(
                        modifier = Modifier.fillMaxWidth().height(300.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(item.image),
                            contentDescription = stringResource(item.title),
                            contentScale = ContentScale.FillWidth,
                        )
                    }
                }
            }

            Column {
                // ✅ Safe now — items is guaranteed non-empty above
                Text(
                    stringResource(items[pagerState.currentPage].title),
                    style = H4.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    stringResource(items[pagerState.currentPage].description),
                    style = Subtitle2.copy(
                        color = MaterialTheme.colorScheme.extendedColors.darkBlue650,
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                DotIndicator(
                    totalDots = items.size,
                    selectedIndex = pagerState.currentPage
                )
            }

            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                ConsumerFilledButton(
                    text = "اضغط هنا",
                    type = ButtonsTypes.PRIMARY,
                    enabled = true,
                    onClick = onContinueClick,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun OnBoardingScreenContentPreview() {
    ConsumerTheme {
        OnBoardingScreenContent(
            onContinueClick = {},
            items = listOf(
                OnBoardingData(
                    image = Res.drawable.illustration_smart_shopping,
                    title = Res.string.shop_smart_title,
                    description = Res.string.shop_smart_description
                ),
                OnBoardingData(
                    image = Res.drawable.illustration_onboarding_my_cart,
                    title = Res.string.compare_your_bucket_title,
                    description = Res.string.compare_your_bucket_description
                ),
                OnBoardingData(
                    image = Res.drawable.illustration_smart_shopping,
                    title = Res.string.shop_smart_title,
                    description = Res.string.shop_smart_description
                ),
                OnBoardingData(
                    image = Res.drawable.illustration_onboarding_my_cart,
                    title = Res.string.compare_your_bucket_title,
                    description = Res.string.compare_your_bucket_description
                )
            )
        )
    }

}


@Composable
fun BottomGlow() {
    val mainColor = MaterialTheme.colorScheme.extendedColors.cadetBlue
    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    mainColor,
                    Color.Transparent
                ),
                center = Offset(
                    x = size.width - 100,
                    y = size.height + 100
                ),
                radius = size.width * 0.5f
            ),
            radius = size.width * 0.5f,
            center = Offset(
                x = size.width - 100,
                y = size.height + 100
            )
        )
    }
}