package com.taraniuk.github.api.paging_library.ui.base.viewModel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

open class BaseModel : ViewModel(){

    var disposable: Disposable? = null

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}