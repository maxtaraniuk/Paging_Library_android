package com.taraniuk.github.api.paging_library.data.repository

import com.taraniuk.github.api.paging_library.data.retrofit.model.Model
import io.reactivex.Single

interface InstantRepositoryApi {

    fun getAllAirline(page: Int, size: Int): Single<Model>

}