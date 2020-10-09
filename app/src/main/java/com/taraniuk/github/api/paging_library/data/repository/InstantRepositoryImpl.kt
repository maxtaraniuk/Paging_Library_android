package com.taraniuk.github.api.paging_library.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.taraniuk.github.api.paging_library.data.retrofit.api.InstantApi
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data
import com.taraniuk.github.api.paging_library.data.retrofit.model.Model
import com.taraniuk.github.api.paging_library.utils.InstantPagingSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import javax.inject.Inject

class InstantRepositoryImpl @Inject constructor(private val retrofit: Retrofit) :
    InstantRepositoryApi {

    override suspend fun getAll(page: Int, size: Int): Model {
        return retrofit.create(InstantApi::class.java).getAll(page, size)
    }

    fun getAllItemsPaging(): Flow<PagingData<Data>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { InstantPagingSource(this) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}
