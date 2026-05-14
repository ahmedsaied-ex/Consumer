package com.example.consumer.core.domain.utils

import com.example.consumer.core.domain.model.DataError
import com.example.consumer.core.presentation.utils.UiText
import consumer.composeapp.generated.resources.Res
import com.example.consumer.core.presentation.utils.UiText.DynamicString
import com.example.consumer.core.presentation.utils.UiText.StringRes
import consumer.composeapp.generated.resources.error_disk_full
import consumer.composeapp.generated.resources.error_insufficient_balance
import consumer.composeapp.generated.resources.error_no_internet
import consumer.composeapp.generated.resources.error_request_timeout
import consumer.composeapp.generated.resources.error_serialization
import consumer.composeapp.generated.resources.error_socket_auction_not_valid
import consumer.composeapp.generated.resources.error_socket_auth_failed
import consumer.composeapp.generated.resources.error_socket_bid_rejected
import consumer.composeapp.generated.resources.error_socket_connection_failed
import consumer.composeapp.generated.resources.error_socket_join_failed
import consumer.composeapp.generated.resources.error_socket_parse_error
import consumer.composeapp.generated.resources.error_socket_price_not_valid
import consumer.composeapp.generated.resources.error_socket_unknown
import consumer.composeapp.generated.resources.error_too_many_requests
import consumer.composeapp.generated.resources.error_unknown


/**
 * Converts a DataError into a UiText object that can be resolved in the UI.
 */

fun DataError.toUiText(): UiText {
    return when (this) {
        is DataError.Remote.VALIDATION -> {
            // Join all validation messages with a newline to display them as a list
            DynamicString(this.errors.errors.joinToString("\n") { it.massage })
        }
        DataError.Local.DISK_FULL -> StringRes(Res.string.error_disk_full)
        DataError.Local.UNKNOWN -> StringRes(Res.string.error_unknown)
        DataError.Remote.REQUEST_TIMEOUT -> StringRes(Res.string.error_request_timeout)
        DataError.Remote.TOO_MANY_REQUESTS -> StringRes(Res.string.error_too_many_requests)
        DataError.Remote.NO_INTERNET -> StringRes(Res.string.error_no_internet)
        is DataError.Remote.SERVER -> {
            DynamicString(this.errors.errors.joinToString("\n") { it.massage })
        }
        DataError.Remote.SERIALIZATION -> StringRes(Res.string.error_serialization)
        DataError.Remote.UNKNOWN -> StringRes(Res.string.error_unknown)
        DataError.Local.INSUFFICIENT_FUNDS -> StringRes(Res.string.error_insufficient_balance)
        DataError.Socket.AUTHENTICATION_FAILED ->
         StringRes(Res.string.error_socket_auth_failed)

        is DataError.Socket.BID_REJECTED ->
           StringRes(Res.string.error_socket_bid_rejected)

        is DataError.Socket.CONNECTION_FAILED ->
            StringRes(Res.string.error_socket_connection_failed)

        is DataError.Socket.JOIN_FAILED ->
            StringRes(Res.string.error_socket_join_failed)

        DataError.Socket.PARSE_ERROR ->
            StringRes(Res.string.error_socket_parse_error)

        DataError.Socket.UNKNOWN ->
            StringRes(Res.string.error_socket_unknown)

        DataError.Socket.PRICE_NOT_VALID ->
            StringRes(Res.string.error_socket_price_not_valid)

        DataError.Socket.AUCTION_NOT_VALID -> StringRes(Res.string.error_socket_auction_not_valid)
    }
}
