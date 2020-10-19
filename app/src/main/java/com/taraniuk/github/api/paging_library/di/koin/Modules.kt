package com.taraniuk.github.api.paging_library.di.koin

import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import com.taraniuk.github.api.paging_library.ui.main.viewModel.MainActivityViewModel
import com.taraniuk.github.api.paging_library.utils.InstantPagingSource
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.instantwebtools.net/"

val viewModule: Module = module {
    viewModel { MainActivityViewModel(get()) }
}

val networkModule: Module = module {
    single { retrofit() }
}

val appModule: Module = module {
    single { InstantRepositoryImpl(get()) }
    single { InstantPagingSource(get()) }
}

fun retrofit(): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build()
}