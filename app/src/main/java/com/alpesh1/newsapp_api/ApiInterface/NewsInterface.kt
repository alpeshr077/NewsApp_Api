package com.alpesh1.newsapp_api.ApiInterface


import com.alpesh1.newsapp_api.NewNewsModelClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    @GET("/v2/everything")

    fun getNews(
        @Query("q")q:String,
        @Query("from")from:String,
        @Query("apiKey")apiKey:String
    ):Call<NewNewsModelClass>

}