package com.example.consumer.core.data.network

import com.example.consumer.core.domain.model.CostumeResult
import com.example.consumer.core.domain.model.DataError
import com.example.consumer.core.domain.model.ErrorModel
import com.example.consumer.core.domain.utils.Error
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse


expect suspend fun <T> platformSafeCall(
    execute: suspend () -> HttpResponse,
    handelResponse: suspend (HttpResponse) -> CostumeResult<T, DataError.Remote>
): CostumeResult<T, DataError.Remote>

suspend inline fun <reified T> safeCall(
    noinline execute: suspend () -> HttpResponse
): CostumeResult<T, DataError.Remote> {
    return platformSafeCall(execute = execute) { response ->
        responseToResult(response)
    }
}
suspend inline fun <reified Request, reified Response : Any> HttpClient.post(
    route: String,
    body: Request,
    queryParams: Map<String, Any> = mapOf(),
    crossinline builder: HttpRequestBuilder.() -> Unit = {}
): CostumeResult<Response, DataError.Remote> {
    return safeCall {
        post {
            url(route)
            queryParams.forEach { (key, value) ->
                parameter(key, value)
            }
            setBody(body)
            builder()
        }
    }
}

suspend inline fun <reified Request, reified Response : Any> HttpClient.put(
    route: String,
    body: Request,
    queryParams: Map<String, Any> = mapOf(),
    crossinline builder: HttpRequestBuilder.() -> Unit = {}
): CostumeResult<Response, DataError.Remote> {
    return safeCall {
        put {
            url(route)
            queryParams.forEach { (key, value) ->
                parameter(key, value)
            }
            setBody(body)
            builder()
        }
    }
}

suspend inline fun <reified Response : Any> HttpClient.get(
    route: String,
    queryParams: Map<String, Any?> = emptyMap(),
    crossinline builder: HttpRequestBuilder.() -> Unit = {}
): CostumeResult<Response, DataError.Remote> {
    return safeCall {
        get {
            url(route)
            queryParams.forEach { (key, value) ->
                parameter(key, value)
            }
            builder()
        }
    }
}



/**
 * Maps HTTP status codes to typed CostumeResult.
 * Deserializes response body on success (2xx).
 */
suspend inline fun <reified T> responseToResult(response: HttpResponse): CostumeResult<T, DataError.Remote> =
    when (response.status.value) {
        in 200..299 -> {
            try {

                CostumeResult.Success(response.body<T>())
            } catch (e: Exception) {

                CostumeResult.Error(DataError.Remote.SERIALIZATION)
            }
        }

        in 400..422  -> {
            try {
                val errorResponse = response.body<ErrorModel>()
                CostumeResult.Error(DataError.Remote.VALIDATION(errorResponse))
            } catch (e: Exception) {
                CostumeResult.Error(DataError.Remote.SERIALIZATION)
            }
        }

        408 -> CostumeResult.Error(DataError.Remote.REQUEST_TIMEOUT)
        429 -> CostumeResult.Error(DataError.Remote.TOO_MANY_REQUESTS)
        in 500..599 ->    try {
            val errorResponse = response.body<ErrorModel>()
            CostumeResult.Error(DataError.Remote.SERVER(errorResponse))
        } catch (e: Exception) {
            CostumeResult.Error(DataError.Remote.SERIALIZATION)
        }
        else -> CostumeResult.Error(DataError.Remote.UNKNOWN)
    }


fun <T, E : Error, R> CostumeResult<T, E>.map(transform: (T) -> R): CostumeResult<R, E> =
    when (this) {
        is CostumeResult.Success -> CostumeResult.Success(transform(data))
        is CostumeResult.Error -> this
    }