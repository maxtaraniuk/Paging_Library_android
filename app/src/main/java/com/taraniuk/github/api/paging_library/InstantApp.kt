package com.taraniuk.github.api.paging_library

import android.app.Application
import com.taraniuk.github.api.paging_library.di.component.Component
import com.taraniuk.github.api.paging_library.di.component.DaggerComponent

class InstantApp : Application() {

    companion object {
        lateinit var daggerComponent: Component
    }

    override fun onCreate() {
        super.onCreate()
        daggerComponent = DaggerComponent.builder().application(this).build()
    }
}