package com.taraniuk.github.api.paging_library.data.repository

import com.taraniuk.github.api.paging_library.data.retrofit.model.Model

interface InstantRepositoryApi {

    suspend fun getAll(page: Int, size: Int): Model

}