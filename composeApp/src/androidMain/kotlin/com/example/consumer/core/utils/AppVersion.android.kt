package com.example.consumer.core.utils

import android.content.pm.PackageManager

actual fun getAppVersion(): String {
    val context = AppContext.context
    return try {
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        packageInfo.versionName ?: "Unknown"
    } catch (e: PackageManager.NameNotFoundException) {
        "Unknown"
    }
}

actual fun getAppBuildNumber(): String {
    val context = AppContext.context
    return try {
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        packageInfo.versionCode.toString()
    } catch (e: PackageManager.NameNotFoundException) {
        "0"
    }
}
