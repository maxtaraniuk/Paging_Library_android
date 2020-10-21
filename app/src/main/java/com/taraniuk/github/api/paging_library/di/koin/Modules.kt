package com.taraniuk.github.api.paging_library.di.koin

import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import com.taraniuk.github.api.paging_library.ui.main.viewModel.MainActivityViewModel
import com.taraniuk.github.api.paging_library.utils.InstantPagingSource
import io.ktor.client.*
import io.ktor.client.features.json.*
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val viewModule: Module = module {
    viewModel { MainActivityViewModel(get()) }
}

val networkModule: Module = module {
    single { okHttpKtor }
}

val appModule: Module = module {
    single { InstantRepositoryImpl(get()) }
    single { InstantPagingSource(get()) }
}

private val okHttpKtor = HttpClient {
    install(JsonFeature) {
        serializer = GsonSerializer()
    }
}