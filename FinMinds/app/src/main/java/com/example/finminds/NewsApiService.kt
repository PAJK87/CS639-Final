package com.example.finminds

import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://newsapi.org/v2/"
const val API_KEY = "eb28e9e5a11e47c39191ba2b13309091"

interface NewsApiService {
    @GET("everything?domains=wsj.com&apiKey=$API_KEY")
    suspend fun getWSJNews() : NewsData.News

    @GET("everything?domains=bloomberg.com&apiKey=$API_KEY")
    suspend fun getBloombergNews() : NewsData.News

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

