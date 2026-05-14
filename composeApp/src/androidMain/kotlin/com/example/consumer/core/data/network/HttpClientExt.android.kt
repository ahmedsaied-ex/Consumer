package com.example.consumer.core.data.network

import com.example.consumer.core.domain.model.CostumeResult
import com.example.consumer.core.domain.model.DataError
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.nio.channels.UnresolvedAddressException


actual suspend fun <T> platformSafeCall(
    execute: suspend () -> HttpResponse,
    handelResponse: suspend (HttpResponse) -> CostumeResult<T, DataError.Remote>
): CostumeResult<T, DataError.Remote> {
    return try {
        val response = execute()
        handelResponse(response)
    } catch(e: UnknownHostException) {
        CostumeResult.Error(DataError.Remote.NO_INTERNET)
    } catch(e: UnresolvedAddressException) {
        CostumeResult.Error(DataError.Remote.NO_INTERNET)
    } catch(e: ConnectException) {
        CostumeResult.Error(DataError.Remote.NO_INTERNET)
    } catch(e: SocketTimeoutException) {
        CostumeResult.Error(DataError.Remote.REQUEST_TIMEOUT)
    } catch(e: HttpRequestTimeoutException) {
        CostumeResult.Error(DataError.Remote.REQUEST_TIMEOUT)
    } catch(e: SerializationException) {
        CostumeResult.Error(DataError.Remote.SERIALIZATION)
    } catch (e: Exception) {
        currentCoroutineContext().ensureActive()
        CostumeResult.Error(DataError.Remote.UNKNOWN)
    }
}
