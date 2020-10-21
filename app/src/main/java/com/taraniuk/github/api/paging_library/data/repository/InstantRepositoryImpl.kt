package com.taraniuk.github.api.paging_library.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.taraniuk.github.api.paging_library.data.ktor.model.Data
import com.taraniuk.github.api.paging_library.data.ktor.model.Model
import com.taraniuk.github.api.paging_library.utils.InstantPagingSource
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow

private const val NETWORK_PAGE_SIZE = 50
private const val BASE_URL = "https://api.instantwebtools.net/"

class InstantRepositoryImpl(private val httpClient: HttpClient) : InstantRepositoryApi {

    override suspend fun getAllAirlines(page: Int, size: Int): Model {
        return httpClient.get("${BASE_URL}v1/passenger?page=$page&size=$size")
    }

    fun getAllItemsPaging(): Flow<PagingData<Data>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { InstantPagingSource(this) }
        ).flow
    }
}
