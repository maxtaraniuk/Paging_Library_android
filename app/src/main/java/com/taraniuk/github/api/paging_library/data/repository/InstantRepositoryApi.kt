package com.taraniuk.github.api.paging_library.data.repository

import androidx.paging.PagingData
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data
import com.taraniuk.github.api.paging_library.data.retrofit.model.Model
import io.reactivex.Flowable
import io.reactivex.Single

interface InstantRepositoryApi {

    fun getAllAirlines(page: Int, size: Int): Single<Model>

    fun getData(): Flowable<PagingData<Data>>
}