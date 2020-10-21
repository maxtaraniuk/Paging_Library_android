package com.taraniuk.github.api.paging_library.utils

import android.util.Log
import androidx.paging.rxjava2.RxPagingSource
import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class InstantPagingSource @Inject constructor(private val repository: InstantRepositoryImpl) :
    RxPagingSource<Int, Data>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Data>> {
        val position = params.key ?: 0

        Log.d("PAGE", "loadSingle: $position")
        return repository.getAllAirlines(position, params.loadSize)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it.data, position) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(data: List<Data>, position: Int): LoadResult<Int, Data> {
        return LoadResult.Page(
            data = data,
            prevKey = if (position == 0) null else position - 1,
            nextKey = if (data.isNullOrEmpty()) null else position + 1
        )
    }
}