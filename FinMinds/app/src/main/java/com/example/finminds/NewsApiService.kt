package com.example.finminds

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://newsapi.org/v2/"
const val API_KEY = "fed5b3657d734724a8c3fa420653f725"

interface NewsApiService {
    @GET("everything?domains=wsj.com&apiKey=$API_KEY")
    suspend fun getNews() : NewsData.News


    companion object {
        var apiService: NewsApiService? = null
        fun getInstance() : NewsApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(NewsApiService::class.java)
            }
            return apiService!!
        }
    }
}

