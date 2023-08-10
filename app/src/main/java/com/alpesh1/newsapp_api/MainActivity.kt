package com.alpesh1.newsapp_api

import android.graphics.pdf.PdfDocument.Page
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import com.alpesh1.newsapp_api.Adapter.NewsAdapter
import com.alpesh1.newsapp_api.ApiClient.NewsClient
import com.alpesh1.newsapp_api.ApiInterface.NewsInterface
import com.alpesh1.newsapp_api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    var page = 1
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: NewsAdapter
    var list = ArrayList<ArticlesItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nested.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {

                page++
                NewsApi(page)
            }
        })

        NewsApi(page)

    }

    private fun NewsApi(page: Int) {
        var Api = NewsClient.getApiClient()?.create(NewsInterface::class.java)
        Api?.getNews(page,"de9738db78ec41e0bcebc4d76be7060a")?.enqueue(object : Callback<NewNewsModelClass>{
            override fun onResponse(call: Call<NewNewsModelClass>, response: Response<NewNewsModelClass>) {

                if (response.isSuccessful){

                     list = response.body()?.articles as ArrayList<ArticlesItem>

//                    list.addAll(data as ArrayList<ArticlesItem>)

                    adapter.setnews(list)
                    binding.rcvNewsList.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rcvNewsList.adapter = adapter

                }

            }

            override fun onFailure(call: Call<NewNewsModelClass>, t: Throwable) {

            }

        })
    }
}