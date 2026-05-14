package com.example.consumer.core.data.logging

import co.touchlab.kermit.Logger
import com.example.consumer.core.domain.utils.CostumeLogger

object KermitLogger : CostumeLogger {
    override fun info(tag: String ,message: String) {
        Logger.i("$tag : $message")
    }

    override fun warn(tag: String ,message: String) {
        Logger.w("$tag : $message")
    }
    override fun error(tag: String, message: String, throwable: Throwable?) {
        Logger.e("$tag : $message",throwable)
    }
    override fun debug(tag: String ,message: String) {
        Logger.d("$tag : $message")
    }

}