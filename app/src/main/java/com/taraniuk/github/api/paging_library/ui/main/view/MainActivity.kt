package com.taraniuk.github.api.paging_library.ui.main.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taraniuk.github.api.paging_library.R
import com.taraniuk.github.api.paging_library.ui.main.viewModel.MainActivityViewModel
import com.taraniuk.github.api.paging_library.utils.InstantRxAdapter
import io.reactivex.disposables.Disposable
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by inject()
    private val rxAdapter = InstantRxAdapter()
    private lateinit var recyclerView: RecyclerView
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv_passengers)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = rxAdapter
        subscribeToPagingData()
    }

    private fun subscribeToPagingData() {
        disposable = viewModel.getResult()
            .subscribe({
                rxAdapter.submitData(lifecycle, it)
            }, {
                Toast.makeText(this, "Something is wrong", Toast.LENGTH_SHORT).show()
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}