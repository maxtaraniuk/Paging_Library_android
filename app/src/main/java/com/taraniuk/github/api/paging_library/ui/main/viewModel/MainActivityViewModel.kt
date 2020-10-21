package com.taraniuk.github.api.paging_library.ui.main.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava2.cachedIn
import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val repository: InstantRepositoryImpl
) : ViewModel() {

    fun getResult(): Flowable<PagingData<Data>> {
        return repository
            .getData()
            .observeOn(AndroidSchedulers.mainThread())
            .cachedIn(viewModelScope)

    }
}