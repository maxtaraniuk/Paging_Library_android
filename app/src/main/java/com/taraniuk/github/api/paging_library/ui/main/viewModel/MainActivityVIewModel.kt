package com.taraniuk.github.api.paging_library.ui.main.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.map
import androidx.paging.rxjava2.cachedIn
import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data
import com.taraniuk.github.api.paging_library.ui.base.viewModel.BaseModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

class MainActivityVIewModel @Inject constructor(private val repository: InstantRepositoryImpl) :
    BaseModel() {

    fun getAllPages() {
        disposable = repository.getAll(10, 10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("TAG", "getAllPages: $it")
            }, {
                Log.d("TAG", "Error: $it")
            })
    }

    fun getFavoriteMovies(): Flowable<PagingData<Data>> {
        return repository
            .getMovies()
            .cachedIn(viewModelScope)
    }

}