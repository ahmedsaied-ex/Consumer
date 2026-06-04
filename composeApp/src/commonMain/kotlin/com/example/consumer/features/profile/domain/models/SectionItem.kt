package com.example.consumer.features.profile.domain.models

sealed class SectionItem {
    data class Static(
        val key: String,
        val value: String
    ) : SectionItem()

    data class Clickable(
        val title: String,
        val suffix: SuffixType,
        val onClick: () -> Unit = {}
    ) : SectionItem()
}
