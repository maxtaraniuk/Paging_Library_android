package com.taraniuk.github.api.paging_library.data.repository

import com.taraniuk.github.api.paging_library.data.ktor.model.Model

interface InstantRepositoryApi {

    suspend fun getAllAirlines(page: Int, size: Int): Model

}