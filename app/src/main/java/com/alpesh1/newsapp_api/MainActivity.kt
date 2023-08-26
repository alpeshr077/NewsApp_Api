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

    var item = arrayOf("India", "World","Hindi","Technology","Sports","Business","Entertainment")
    var fragments =
        arrayOf(India_Fragment(), world_Fragment(),Hindi_Fragment(),Technology_Fragment(),Sports_Fragment(),Business_Fragment(),Entertainment_Fragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = FragmentAdapter(supportFragmentManager, fragments, item)
        binding.TabLayout.setupWithViewPager(binding.viewPager)

    }

}