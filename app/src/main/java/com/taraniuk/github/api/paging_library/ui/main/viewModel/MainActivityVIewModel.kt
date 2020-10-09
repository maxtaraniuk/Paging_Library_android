package com.taraniuk.github.api.paging_library.ui.main.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityVIewModel @Inject constructor(private val repository: InstantRepositoryImpl) :
    ViewModel() {

    fun getAllPages() {
        viewModelScope.launch {
            val m = repository.getAll(10, 10)
            Log.d("TAG", "getAllPages: $m")
        }
    }

    fun getData(): Flow<PagingData<Data>> {
        return repository.getAllItemsPaging().cachedIn(viewModelScope)
    }

}

