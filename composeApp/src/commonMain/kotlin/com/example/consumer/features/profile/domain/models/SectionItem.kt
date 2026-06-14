package com.example.consumer.features.profile.domain.models

import org.jetbrains.compose.resources.StringResource

sealed class SectionItem {
    data class Static(
        val key: String,
        val value: String
    ) : SectionItem()

    data class Clickable(
        val title: StringResource,
        val suffix: SuffixType,
        val onClick: () -> Unit = {}
    ) : SectionItem()
}
