package com.taraniuk.github.api.paging_library.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taraniuk.github.api.paging_library.R
import com.taraniuk.github.api.paging_library.ui.main.viewModel.MainActivityViewModel
import com.taraniuk.github.api.paging_library.utils.DataAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by inject()

    lateinit var recycler: RecyclerView
    private val adapter = DataAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.rv_passengers)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        run()
    }

    private fun run() {
        lifecycleScope.launch {
            val pagingData = viewModel.getData()

            pagingData.collect {
                adapter.submitData(it)
            }
        }
    }
}