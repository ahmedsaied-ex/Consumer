package com.example.consumer.features.profile.domain.models

sealed class SuffixType {
    data object ChevronOnly : SuffixType()
    data class TextAndChevron(val label: String) : SuffixType()
}
