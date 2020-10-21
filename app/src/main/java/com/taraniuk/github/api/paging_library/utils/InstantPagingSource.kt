package com.taraniuk.github.api.paging_library.utils

import androidx.paging.PagingSource
import com.bumptech.glide.load.HttpException
import com.taraniuk.github.api.paging_library.data.ktor.model.Data
import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import java.io.IOException

class InstantPagingSource(private val repository: InstantRepositoryImpl) :
    PagingSource<Int, Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val position = params.key ?: 1

        return try {
            val response = repository.getAllAirlines(position, params.loadSize)
            val repos = response.data
            LoadResult.Page(
                data = repos,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (repos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}