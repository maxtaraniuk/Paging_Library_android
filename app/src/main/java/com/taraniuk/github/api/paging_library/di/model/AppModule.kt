package com.taraniuk.github.api.paging_library.di.model

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providersContext(app: Application): Context = app
}