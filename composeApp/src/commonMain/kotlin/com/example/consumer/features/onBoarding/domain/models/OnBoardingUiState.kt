package com.example.consumer.features.onBoarding.domain.models

import com.example.consumer.core.presentation.components.tabBar.TabItem
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ambassador
import consumer.composeapp.generated.resources.consumer

data class OnBoardingUiState (
    val selectedTabId: String? = AuthTabs.CONSUMER.name,
    val tabs: List<TabItem> = listOf(
        TabItem(
            id = AuthTabs.CONSUMER.name,
            title =Res.string.consumer
        ),
        TabItem(
            id = AuthTabs.AMBASSADOR.name,
            title = Res.string.ambassador
        )
    ),
    val onBoardingScreens : List<OnBoardingData> = listOf(),
    val selectedTab: AuthTabs = AuthTabs.CONSUMER,
    val isBottomSheetOpened : Boolean= false,

)