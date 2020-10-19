package com.taraniuk.github.api.paging_library.di.model

import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryApi
import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(repositoryImpl: InstantRepositoryImpl): InstantRepositoryApi
}