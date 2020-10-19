package com.taraniuk.github.api.paging_library.data.repository

import com.taraniuk.github.api.paging_library.data.retrofit.model.Model
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

const val PAGE = 1
const val SIZE = 1

class InstantRepositoryImplTest {

    @Mock
    private lateinit var repositoryImpl: InstantRepositoryImpl

    @Mock
    private lateinit var model: Model

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getAllAirlines_should_return_Model() {
        Mockito.`when`(repositoryImpl.getAllAirlines(PAGE, SIZE)).thenReturn(Single.just(model))

        repositoryImpl.getAllAirlines(PAGE, SIZE)
            .test()
            .assertResult(model)
    }

}