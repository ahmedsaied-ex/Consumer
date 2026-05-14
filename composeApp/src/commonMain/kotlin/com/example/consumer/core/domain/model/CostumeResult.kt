package com.example.consumer.core.domain.model

import com.example.consumer.core.domain.utils.Error

/**
 * A sealed interface representing the result of an operation that can either succeed or fail.
 * This provides a type-safe alternative to exception-based error handling.
 *
 * @param D The type of data returned on success
 * @param E The type of error returned on failure (must extend Error)
 */
sealed interface CostumeResult<out D, out E : Error> {
    /**
     * Represents a successful operation result containing data.
     * Uses Nothing as the error type since success cannot have an error.
     */
    data class Success<out D>(
        val data: D,
    ) : CostumeResult<D, Nothing>

    /**
     * Represents a failed operation result containing error information.
     * Uses Nothing as the data type since errors don't carry success data.
     */
    data class Error <out E : com.example.consumer.core.domain.utils.Error>(
        val error: E,
    ) : CostumeResult<Nothing, E>
}

/**
 * Transforms the success data of a Result using the provided mapping function.
 * Only applies transformation if Result is Success, otherwise passes Error unchanged.
 *
 * @param map Function to transform success data
 * @return New Result with transformed data or original error
 */
inline fun <T, E : Error, R> CostumeResult<T, E>.map(map: (T) -> R): CostumeResult<R, E> =
    when (this) {
        is CostumeResult.Error -> CostumeResult.Error(error) // Pass through the error unchanged
        is CostumeResult.Success -> CostumeResult.Success(map(data)) // Transform the success data
    }

/**
 * Converts Result to EmptyResult (Result<Unit, E>).
 * Useful when only caring about success/failure status.
 *
 * @return EmptyResult preserving error type, discarding success data
 */
fun <T, E : Error> CostumeResult<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map { } // Map to Unit, effectively discarding the data
}

/**
 * Executes action if Result is Success, returns original Result.
 * Enables method chaining for success operations.
 *
 * @param action Function to execute with success data
 * @return Original Result unchanged for chaining
 */
inline fun <T, E : Error> CostumeResult<T, E>.onSuccess(action: (T) -> Unit): CostumeResult<T, E> =
    when (this) {
        is CostumeResult.Error -> this // Return unchanged if error
        is CostumeResult.Success -> {
            action(data) // Execute the side-effect with success data
            this // Return the original Result for chaining
        }
    }

/**
 * Executes action if Result is Error, returns original Result.
 * Enables method chaining for error handling (logging, analytics).
 *
 * @param action Function to execute with error data
 * @return Original Result unchanged for chaining
 */
inline fun <T, E : Error> CostumeResult<T, E>.onError(action: (E) -> Unit): CostumeResult<T, E> =
    when (this) {
        is CostumeResult.Error -> {
            action(error) // Execute the side-effect with error data
            this // Return the original Result for chaining
        }

        is CostumeResult.Success -> this // Return unchanged if success
    }

/**
 * Logs error if Result is Error, returns original Result.
 * Useful for error tracking and debugging.
 *
 * @param logger Logger instance to use
 * @param tag Tag for logging
 * @param message Optional custom message
 * @return Original Result unchanged for chaining
 */
fun <T, E : Error> CostumeResult<T, E>.logError(
    logger: Logger,
    tag: String,
    message: String = "Operation failed",
): CostumeResult<T, E> =
    onError { error ->
        logger.error(tag, "$message: $error")
    }

/**
 * Logs analytics event if Result is Error.
 *
 * @param analytics Analytics logger instance
 * @param eventName Name of the error event
 * @param additionalData Additional data to log
 * @return Original Result unchanged for chaining
 */
fun <T, E : Error> CostumeResult<T, E>.logAnalyticsError(
    analytics: AnalyticsLogger,
    eventName: String,
    additionalData: Map<String, Any> = emptyMap(),
): CostumeResult<T, E> =
    onError { error ->
        analytics.logEvent(eventName, additionalData + mapOf("error" to error.toString()))
    }

/**
 * Result that carries no data on success, only Unit.
 * For operations where only success/failure status matters.
 *
 * Example: API calls confirming action completion.
 */
typealias EmptyResult<E> = CostumeResult<Unit, E>
