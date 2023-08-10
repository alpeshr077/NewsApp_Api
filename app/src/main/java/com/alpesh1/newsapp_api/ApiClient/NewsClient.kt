package com.alpesh1.newsapp_api.ApiClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsClient {

    companion object {

        val BASE_URL = "https://newsapi.org"
        var retrofit: Retrofit? = null

        fun getApiClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!

        }

    }

}