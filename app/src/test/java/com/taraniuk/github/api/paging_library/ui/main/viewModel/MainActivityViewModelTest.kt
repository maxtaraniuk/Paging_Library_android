package com.taraniuk.github.api.paging_library.ui.main.viewModel

import androidx.paging.PagingData
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainActivityViewModelTest {

    @Mock
    private lateinit var viewModel: MainActivityViewModel

    @Mock
    private lateinit var pagingData: PagingData<Data>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getResult_should_return_PagingData() {
        Mockito.`when`(viewModel.getResult()).thenReturn(Flowable.just(pagingData))

        viewModel.getResult()
            .test()
            .assertResult(pagingData)
    }
}