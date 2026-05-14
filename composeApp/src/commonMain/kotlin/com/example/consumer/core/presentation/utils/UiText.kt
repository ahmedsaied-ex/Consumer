package com.example.consumer.core.presentation.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource

sealed interface UiText {
    data class DynamicString(val value: String) :
        UiText

    class StringRes(val res: StringResource, val args: Array<Any> = emptyArray()) :
        UiText

    suspend fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is StringRes -> getString(resource = res, *args)
        }
    }

    @Composable
    fun asStringComposable(): String {
        return when (this) {
            is DynamicString -> value
            is StringRes -> stringResource(res, *args)
        }
    }
}