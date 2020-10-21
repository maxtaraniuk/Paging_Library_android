package com.taraniuk.github.api.paging_library.di.model

import androidx.lifecycle.ViewModelProvider
import com.taraniuk.github.api.paging_library.di.factory.InstantViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindsViewModelFactory(factory: InstantViewModelFactory): ViewModelProvider.Factory
}
