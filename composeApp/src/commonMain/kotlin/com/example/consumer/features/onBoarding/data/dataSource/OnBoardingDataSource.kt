package com.example.consumer.features.onBoarding.data.dataSource

import com.example.consumer.features.onBoarding.domain.models.OnBoardingData
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.compare_your_bucket_description
import consumer.composeapp.generated.resources.compare_your_bucket_title
import consumer.composeapp.generated.resources.illustration_onboarding_my_cart3
import consumer.composeapp.generated.resources.illustration_smart_shopping3
import consumer.composeapp.generated.resources.shop_smart_description
import consumer.composeapp.generated.resources.shop_smart_title

class OnBoardingDataSource {
    fun getOnBoardingData() : List<OnBoardingData> {
        return listOf(
            OnBoardingData(
                image = Res.drawable.illustration_smart_shopping3,
                title = Res.string.shop_smart_title,
                description = Res.string.shop_smart_description
            ),
            OnBoardingData(
                image = Res.drawable.illustration_onboarding_my_cart3,
                title = Res.string.compare_your_bucket_title,
                description = Res.string.compare_your_bucket_description
            )
        )
    }
}