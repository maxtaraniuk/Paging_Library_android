package com.taraniuk.github.api.paging_library.utils

import androidx.paging.PagingSource
import com.bumptech.glide.load.HttpException
import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data
import java.io.IOException
import javax.inject.Inject

class InstantPagingSource @Inject constructor(private val repository: InstantRepositoryImpl) :
    PagingSource<Int, Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val position = params.key ?: 1

        return try {
            val response = repository.getAll(position, params.loadSize)
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