package com.taraniuk.github.api.paging_library.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.taraniuk.github.api.paging_library.R
import com.taraniuk.github.api.paging_library.data.retrofit.model.Data

class MoviesRxAdapter : PagingDataAdapter<Data, MovieGridViewHolder>(
    COMPARATOR
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieGridViewHolder {
        return MovieGridViewHolder.create(
            parent
        )
    }

    override fun onBindViewHolder(holder: MovieGridViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class MovieGridViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val t1 : TextView  = view.findViewById(R.id.textView)
    val t2 : TextView  = view.findViewById(R.id.textView3)
    val t3 : TextView  = view.findViewById(R.id.textView2)
    fun bind(movie: Data) {
        with(movie) {
            t1.text = movie.name
            t2.text = movie.name
            t3.text = movie.name
        }
    }

    companion object {
        fun create(parent: ViewGroup): MovieGridViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_passegers,  parent,false)


            return MovieGridViewHolder(
                view
            )
        }
    }
}