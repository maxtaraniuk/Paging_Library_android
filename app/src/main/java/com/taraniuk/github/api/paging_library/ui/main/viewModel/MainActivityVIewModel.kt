package com.taraniuk.github.api.paging_library.ui.main.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava2.cachedIn
import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data
import com.taraniuk.github.api.paging_library.ui.base.viewModel.BaseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainActivityVIewModel @Inject constructor(private val repository: InstantRepositoryImpl) :
    BaseModel() {

    val pagingData = MutableLiveData<PagingData<Data>>()

    init {
        getResult()
    }

    private fun getResult() {
        disposable = repository
            .getMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .cachedIn(viewModelScope)
            .subscribe({
                pagingData.value = it
            }, {

            })
    }
}