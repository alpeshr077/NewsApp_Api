package com.alpesh1.newsapp_api.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alpesh1.newsapp_api.ArticlesItem
import com.alpesh1.newsapp_api.databinding.NewsItemsBinding

class NewsAdapter : Adapter<NewsAdapter.NewsHolder>() {

    lateinit var context: Context
    lateinit var newsList: List<ArticlesItem>

    class NewsHolder(itemView: NewsItemsBinding) : ViewHolder(itemView.root) {
        var binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {

        context = parent.context
        var binding = NewsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NewsHolder(binding)
    }

    override fun getItemCount(): Int {

        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {

        holder.binding.apply {
            newsList.get(position)?.apply {

                txtTitle.text = title.toString()
                txtAuthor.text = author.toString()
                txtDescription.text = description.toString()
            }
        }
    }

    fun setnews(list: List<ArticlesItem>) {
        this.newsList = list
    }

}