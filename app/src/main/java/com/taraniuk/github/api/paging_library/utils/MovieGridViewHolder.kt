package com.taraniuk.github.api.paging_library.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taraniuk.github.api.paging_library.R
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data

class MovieGridViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.findViewById(R.id.tv_name)
    private val slogan: TextView = view.findViewById(R.id.city)
    private val country: TextView = view.findViewById(R.id.country)
    private val image: ImageView = view.findViewById(R.id.iv_logo)

    fun bind(movie: Data) {
        name.text = movie.airline.name
        slogan.text = movie.airline.slogan
        country.text = movie.airline.country
        loadImage(movie.airline.logo)
    }

    private fun loadImage(url: String) {
        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(image)
    }

    companion object {
        fun create(parent: ViewGroup): MovieGridViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_airlines, parent, false)
            return MovieGridViewHolder(view)
        }
    }
}