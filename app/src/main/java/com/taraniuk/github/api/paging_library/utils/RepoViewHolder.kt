package com.taraniuk.github.api.paging_library.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taraniuk.github.api.paging_library.R
import com.taraniuk.github.api.paging_library.data.ktor.model.Data

class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.tv_name)
    private val country: TextView = view.findViewById(R.id.tv_country)
    private val city: TextView = view.findViewById(R.id.tv_city)
    private val logo: ImageView = view.findViewById(R.id.iv_logo)

    fun bind(repo: Data?) {
        repo?.let {
            name.text = repo.name
            country.text = repo.airline.country
            city.text = repo.airline.slogan

            Glide.with(itemView.context)
                .load(repo.airline.logo)
                .into(logo)
        }
    }

    companion object {
        fun create(parent: ViewGroup): RepoViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_passegers, parent, false)
            return RepoViewHolder(view)
        }
    }
}
