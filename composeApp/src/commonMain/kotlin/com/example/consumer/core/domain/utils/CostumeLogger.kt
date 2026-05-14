package com.example.consumer.core.domain.utils

interface CostumeLogger {
    fun info(tag: String ,message: String)
    fun warn(tag: String ,message: String)
    fun error(tag: String,message: String,throwable: Throwable?=null)
    fun debug(tag: String, message: String)
}