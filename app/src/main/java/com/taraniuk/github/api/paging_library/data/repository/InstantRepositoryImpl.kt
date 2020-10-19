package com.taraniuk.github.api.paging_library.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import com.taraniuk.github.api.paging_library.data.retrofit.api.InstantApi
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data
import com.taraniuk.github.api.paging_library.data.retrofit.model.Model
import com.taraniuk.github.api.paging_library.utils.InstantPagingSource
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.Retrofit

private const val PAGE_SIZE = 10
private const val MAX_SIZE = 30
private const val INITIAL_LOAD_SIZE = 40
private const val PREFETCH_DISTANCE = 5
private const val ENABLE_PLACEHOLDERS = false

class InstantRepositoryImpl(private val retrofit: Retrofit) :
    InstantRepositoryApi {


    override fun getAllAirlines(page: Int, size: Int): Single<Model> {
        return retrofit.create(InstantApi::class.java).getAll(page, size)
    }

    fun getData(): Flowable<PagingData<Data>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = ENABLE_PLACEHOLDERS,
                maxSize = MAX_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
                initialLoadSize = INITIAL_LOAD_SIZE
            ),
            pagingSourceFactory = { InstantPagingSource(this) }
        ).flowable
    }
}
