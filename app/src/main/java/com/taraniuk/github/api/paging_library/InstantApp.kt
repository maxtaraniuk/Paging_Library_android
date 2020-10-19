package com.taraniuk.github.api.paging_library

import android.app.Application
import com.taraniuk.github.api.paging_library.di.koin.appModule
import com.taraniuk.github.api.paging_library.di.koin.networkModule
import com.taraniuk.github.api.paging_library.di.koin.viewModule
import org.koin.android.ext.android.startKoin

class InstantApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(viewModule, networkModule, appModule))
    }
}