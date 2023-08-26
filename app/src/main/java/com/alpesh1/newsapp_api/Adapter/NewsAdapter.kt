package com.alpesh1.newsapp_api.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alpesh1.newsapp_api.ArticlesItem
import com.alpesh1.newsapp_api.ClickHere
import com.alpesh1.newsapp_api.databinding.NewsItemsBinding
import com.bumptech.glide.Glide

class NewsAdapter(newsList: ArrayList<ArticlesItem>,clicknow: ClickHere) : Adapter<NewsAdapter.NewsHolder>() {

    lateinit var context: Context
    var List = newsList
    var Clicknow = clicknow

    class NewsHolder(itemView: NewsItemsBinding) : ViewHolder(itemView.root) {

        var binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {

        context = parent.context
        var binding = NewsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NewsHolder(binding)
    }

    override fun getItemCount(): Int {

        return List.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {

        holder.binding.apply {
            List.get(position)?.apply {

                Glide.with(context).load(List.get(position).urlToImage).into(holder.binding.imgImage)
                txtTitle.text = title.toString()
                txtPublish.text = publishedAt.toString()

                holder.itemView.setOnClickListener {
                    Clicknow.onclick(position)

                }

            }
        }
    }
}

