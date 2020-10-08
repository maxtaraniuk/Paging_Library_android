package com.taraniuk.github.api.paging_library.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taraniuk.github.api.paging_library.InstantApp
import com.taraniuk.github.api.paging_library.R
import com.taraniuk.github.api.paging_library.ui.main.viewModel.MainActivityVIewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel : MainActivityVIewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InstantApp.daggerComponent.inject(this)
        setContentView(R.layout.activity_main)
        viewModel.getAllPages()
    }
}