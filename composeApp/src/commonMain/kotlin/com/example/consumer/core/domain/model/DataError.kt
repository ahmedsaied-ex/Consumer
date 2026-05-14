package com.example.consumer.core.domain.model

import com.example.consumer.core.domain.utils.Error
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Sealed interface that defines all possible data-related errors in the application.
 * Extends the base Error interface to provide type safety for Result types.
 */
sealed interface DataError : Error {

    sealed interface Remote : DataError {
        data object REQUEST_TIMEOUT : Remote
        data object TOO_MANY_REQUESTS : Remote
        data object NO_INTERNET : Remote
        data class SERVER(val errors: ErrorModel) : Remote
        data object SERIALIZATION : Remote
        data object UNKNOWN : Remote
        data class VALIDATION(val errors: ErrorModel) : Remote
    }

    // ──────────────────────────────────────────────────────
    // NEW: Socket-specific errors, kept separate from Remote
    // so your existing mapper `when` branches are unaffected.
    // ──────────────────────────────────────────────────────
    sealed interface Socket : DataError {

        /**
         * The WebSocket connection itself failed.
         * [reason] is a human-readable string from the socket library.
         */
        data class CONNECTION_FAILED(val reason: String) : Socket

        /**
         * We connected but the server rejected our JWT token.
         * This usually means the token is expired.
         */
        data object AUTHENTICATION_FAILED : Socket

        /**
         * We tried to join an auction room but the server refused.
         */
        data class JOIN_FAILED(val auctionId: String) : Socket

        /**
         * The bid we submitted was rejected by the server.
         * [reason] contains the server's rejection message.
         */
        data class BID_REJECTED(val reason: String) : Socket

        /**
         * A payload from the server could not be parsed into
         * our expected data class.
         */
        data object PARSE_ERROR : Socket
        data object PRICE_NOT_VALID : Socket
        data object AUCTION_NOT_VALID : Socket


        /**
         * Catch-all for unexpected socket errors.
         */
        data object UNKNOWN : Socket
    }

    enum class Local : DataError {
        DISK_FULL,
        INSUFFICIENT_FUNDS,
        UNKNOWN,
    }
}

/**
 * Model representing a single field validation error from the API
 */
@Serializable
data class ApiValidationError(
    val field: String,
    @SerialName("massage") val message: String // Using "massage" to match your API response
)

/**
 * Wrapper for the API error response
 */
@Serializable
data class ApiErrorResponse(
    val errors: List<ApiValidationError>
)
