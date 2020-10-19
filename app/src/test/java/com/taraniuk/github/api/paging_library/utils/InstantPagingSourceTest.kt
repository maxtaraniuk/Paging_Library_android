package com.taraniuk.github.api.paging_library.utils

import androidx.paging.PagingSource
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class InstantPagingSourceTest {

    @Mock
    private lateinit var result: PagingSource.LoadResult<Int, Data>

    @Mock
    private lateinit var params: PagingSource.LoadParams<Int>

    @Mock
    private lateinit var instantPagingSource: InstantPagingSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun loadSingle_should_return_single_loadResult() {
        Mockito.`when`(instantPagingSource.loadSingle(params)).thenReturn(Single.just(result))

        instantPagingSource.loadSingle(params)
            .test()
            .assertResult(result)
    }


}