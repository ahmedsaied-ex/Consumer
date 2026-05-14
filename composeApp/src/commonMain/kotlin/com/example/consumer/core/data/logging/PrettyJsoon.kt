package com.example.consumer.core.data.logging

import com.example.consumer.core.domain.utils.CostumeLogger
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json


@OptIn(ExperimentalSerializationApi::class)
private val prettyJson = Json {
    prettyPrint = true
    prettyPrintIndent = " "
    isLenient = true
    ignoreUnknownKeys = true
}


fun formatIfJson(text: String): String =
    try {
        if (text.startsWith("{") || text.startsWith("[")) {
            prettyJson.encodeToString(
                kotlinx.serialization.json.JsonElement.serializer(),
                prettyJson.parseToJsonElement(text)
            )
        } else text
    } catch (_: Exception) {
        text
    }
fun logLong(
    tag: String,
    message: String,
    logger: CostumeLogger
) {
    val chunkSize = Int.MAX_VALUE
    var index = 0


    while (index < message.length) {
        val end = minOf(message.length, index + chunkSize)
        logger.info("[$tag]","[$tag]\n${message.substring(index, end)}")
        index = end
    }
}
