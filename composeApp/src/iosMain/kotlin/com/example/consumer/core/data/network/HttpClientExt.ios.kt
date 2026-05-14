package com.example.consumer.core.data.network

import com.example.consumer.core.domain.model.CostumeResult
import com.example.consumer.core.domain.model.DataError
import io.ktor.client.engine.darwin.DarwinHttpRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import platform.Foundation.NSURLErrorCallIsActive
import platform.Foundation.NSURLErrorCannotFindHost
import platform.Foundation.NSURLErrorDNSLookupFailed
import platform.Foundation.NSURLErrorDataNotAllowed
import platform.Foundation.NSURLErrorDomain
import platform.Foundation.NSURLErrorInternationalRoamingOff
import platform.Foundation.NSURLErrorNetworkConnectionLost
import platform.Foundation.NSURLErrorNotConnectedToInternet
import platform.Foundation.NSURLErrorResourceUnavailable
import platform.Foundation.NSURLErrorTimedOut

actual suspend fun <T> platformSafeCall(
    execute: suspend () -> HttpResponse,
    handelResponse: suspend (HttpResponse) -> CostumeResult<T, DataError.Remote>
): CostumeResult<T, DataError.Remote> {
    return try {
        val response = execute()
        handelResponse(response)
    } catch(e: DarwinHttpRequestException) {
        handleDarwinException(e)
    } catch(e: UnresolvedAddressException) {
        CostumeResult.Error(DataError.Remote.NO_INTERNET)
    }  catch(e: HttpRequestTimeoutException) {
        CostumeResult.Error(DataError.Remote.REQUEST_TIMEOUT)
    } catch(e: SerializationException) {
        CostumeResult.Error(DataError.Remote.SERIALIZATION)
    } catch (e: Exception) {
        currentCoroutineContext().ensureActive()
        CostumeResult.Error(DataError.Remote.UNKNOWN)
    }
}

private fun handleDarwinException(e: DarwinHttpRequestException): CostumeResult<Nothing, DataError.Remote> {
    val nsError = e.origin

    return if(nsError.domain == NSURLErrorDomain) {
        when(nsError.code) {
            NSURLErrorNotConnectedToInternet,
            NSURLErrorNetworkConnectionLost,
            NSURLErrorCannotFindHost,
            NSURLErrorDNSLookupFailed,
            NSURLErrorResourceUnavailable,
            NSURLErrorInternationalRoamingOff,
            NSURLErrorCallIsActive,
            NSURLErrorDataNotAllowed -> {
                CostumeResult.Error(DataError.Remote.NO_INTERNET)
            }

            NSURLErrorTimedOut -> CostumeResult.Error(DataError.Remote.REQUEST_TIMEOUT)
            else -> CostumeResult.Error(DataError.Remote.UNKNOWN)
        }
    } else CostumeResult.Error(DataError.Remote.UNKNOWN)
}
