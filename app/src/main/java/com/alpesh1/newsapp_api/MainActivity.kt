package com.alpesh1.newsapp_api

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alpesh1.newsapp_api.Adapter.NewsAdapter
import com.alpesh1.newsapp_api.ApiClient.NewsClient
import com.alpesh1.newsapp_api.ApiInterface.NewsInterface
import com.alpesh1.newsapp_api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: NewsAdapter

    companion object {
        var List = ArrayList<ArticlesItem>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var Api = NewsClient.getApiClient()?.create(NewsInterface::class.java)

        Api?.getNews(
            "india",
            "2023-08-24T09:33:39Z",
            "de9738db78ec41e0bcebc4d76be7060a"
        )
            ?.enqueue(object : Callback<NewNewsModelClass> {
                override fun onResponse(
                    call: Call<NewNewsModelClass>,
                    response: Response<NewNewsModelClass>
                ) {

                    List = response.body()?.articles as ArrayList<ArticlesItem>

                    if (response.isSuccessful) {


                        var clickNow = object : ClickHere {
                            override fun onclick(position: Int) {

                                var intent = Intent(
                                    this@MainActivity,
                                    News_Details::class.java
                                ).putExtra("pos", position)
                                startActivity(intent)
                            }

                        }

                        binding.rcvNewsList.layoutManager = LinearLayoutManager(this@MainActivity)
                        binding.rcvNewsList.adapter = NewsAdapter(List, clickNow)

                    }

                }

                override fun onFailure(call: Call<NewNewsModelClass>, t: Throwable) {

                }

            })

    }

}