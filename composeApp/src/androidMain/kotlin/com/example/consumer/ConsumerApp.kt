package com.example.consumer

import android.app.Application
import com.example.consumer.core.di.initKoin
import com.example.consumer.core.utils.AppContext
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class ConsumerApp : Application(),
    KoinComponent {
    override fun onCreate() {
        super.onCreate()
        AppContext.initialize(this)
        initKoin {
            androidLogger()
            androidContext(this@ConsumerApp)
        }
    }
}

