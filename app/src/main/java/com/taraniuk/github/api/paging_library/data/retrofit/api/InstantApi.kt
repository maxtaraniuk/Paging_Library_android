package com.taraniuk.github.api.paging_library.data.retrofit.api

import com.taraniuk.github.api.paging_library.data.retrofit.model.Model
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface InstantApi {

    @GET("v1/passenger")
    fun getAll(
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Single<Model>

}