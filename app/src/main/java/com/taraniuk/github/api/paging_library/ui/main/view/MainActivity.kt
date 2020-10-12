package com.taraniuk.github.api.paging_library.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taraniuk.github.api.paging_library.InstantApp
import com.taraniuk.github.api.paging_library.R
import com.taraniuk.github.api.paging_library.ui.main.viewModel.MainActivityVIewModel
import com.taraniuk.github.api.paging_library.utils.InstantRxAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityVIewModel
    private val rxAdapter = InstantRxAdapter()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InstantApp.daggerComponent.inject(this)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv_passengers)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = rxAdapter
        subscribeToPagingData()
    }

    private fun subscribeToPagingData() {
        viewModel.pagingData.observe(this, {
            rxAdapter.submitData(lifecycle, it)
        })

    }
}