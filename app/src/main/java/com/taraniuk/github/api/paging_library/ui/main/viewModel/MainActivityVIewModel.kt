package com.taraniuk.github.api.paging_library.ui.main.viewModel

import android.util.Log
import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import com.taraniuk.github.api.paging_library.ui.base.viewModel.BaseModel
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

}