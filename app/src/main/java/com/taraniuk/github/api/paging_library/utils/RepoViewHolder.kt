/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

/**
 * View Holder for a [Repo] RecyclerView list item.
 */
class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val t1: TextView = view.findViewById(R.id.tv_name)
    private val t2: TextView = view.findViewById(R.id.tv_name)
    private val logo: ImageView = view.findViewById(R.id.iv_logo)


    private var repo: Data? = null

//    init {
//        view.setOnClickListener {
//            repo?.url.let { url ->
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                view.context.startActivity(intent)
//            }
//        }
//    }

    fun bind(repo: Data?) {
        if (repo == null) {
//            val resources = itemView.resources
//            name.text = resources.getString(R.string.loading)
//            description.visibility = View.GONE
//            language.visibility = View.GONE
//            stars.text = resources.getString(R.string.unknown)
//            forks.text = resources.getString(R.string.unknown)
        } else {
            showRepoData(repo)
        }
    }

    private fun showRepoData(repo: Data) {
        this.repo = repo
        t1.text = repo.name

        Glide.with(itemView.context)
            .load(repo.airline.logo)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(logo)

        t2.text = repo.name
    }

    companion object {
        fun create(parent: ViewGroup): RepoViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_passegers, parent, false)
            return RepoViewHolder(view)
        }
    }
}
