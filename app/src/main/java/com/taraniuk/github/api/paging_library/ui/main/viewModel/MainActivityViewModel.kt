package com.taraniuk.github.api.paging_library.ui.main.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.taraniuk.github.api.paging_library.data.ktor.model.Data
import com.taraniuk.github.api.paging_library.data.repository.InstantRepositoryImpl
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel(private val repository: InstantRepositoryImpl) :
    ViewModel() {


    fun getData(): Flow<PagingData<Data>> {
        return repository.getAllItemsPaging().cachedIn(viewModelScope)
    }

}

