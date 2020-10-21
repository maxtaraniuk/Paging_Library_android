package com.taraniuk.github.api.paging_library.data.ktor.model

data class Model(
    var totalPages: Int,
    var totalPassengers: Int,
    var data: List<Data>
)