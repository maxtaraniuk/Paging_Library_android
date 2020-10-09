package com.taraniuk.github.api.paging_library.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taraniuk.github.api.paging_library.InstantApp
import com.taraniuk.github.api.paging_library.R
import com.taraniuk.github.api.paging_library.ui.main.viewModel.MainActivityVIewModel
import com.taraniuk.github.api.paging_library.utils.InstantRxAdapter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel : MainActivityVIewModel
    private val rxAdapter = InstantRxAdapter()
    lateinit var recyclerView: RecyclerView
    var mDisposable : CompositeDisposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InstantApp.daggerComponent.inject(this)
        setContentView(R.layout.activity_main)
        viewModel.getAllPages()

        recyclerView = findViewById(R.id.rv_passengers)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = rxAdapter

        mDisposable?.add(viewModel.getFavoriteMovies().subscribe {
            rxAdapter.submitData(lifecycle, it)
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable?.dispose()
    }
}