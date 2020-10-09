package com.taraniuk.github.api.paging_library.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taraniuk.github.api.paging_library.InstantApp
import com.taraniuk.github.api.paging_library.R
import com.taraniuk.github.api.paging_library.ui.main.viewModel.MainActivityVIewModel
import com.taraniuk.github.api.paging_library.utils.DataAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityVIewModel

    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InstantApp.daggerComponent.inject(this)
        setContentView(R.layout.activity_main)
        viewModel.getAllPages()

        recycler = findViewById(R.id.rv_passengers)
        recycler.layoutManager = LinearLayoutManager(this)
        run()
    }


    private fun run() {
        lifecycleScope.launch {
            val a = viewModel.getData()
            val adapter = DataAdapter()
            a.collect {
                adapter.submitData(it)
                Log.d("111", "run: $it")
            }
            recycler.adapter = adapter
        }
    }
}