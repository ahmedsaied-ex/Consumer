package com.example.consumer.core.utils

import platform.Foundation.NSBundle

actual fun getAppVersion(): String {
    val infoDict = NSBundle.mainBundle.infoDictionary ?: return "Unknown"
    return infoDict["CFBundleShortVersionString"] as? String ?: "Unknown"
}

actual fun getAppBuildNumber(): String {
    val infoDict = NSBundle.mainBundle.infoDictionary ?: return "0"
    return infoDict["CFBundleVersion"] as? String ?: "0"
}
