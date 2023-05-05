package com.example.finminds

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NewsView : ViewModel() {
    var wsjNewsResponse:Array<NewsData.Articles> by mutableStateOf(arrayOf())
    var bloombergNewsResponse:Array<NewsData.Articles> by mutableStateOf(arrayOf())
    var errorMessage: String by mutableStateOf("")

    fun getWsjList() {
        viewModelScope.launch {
            val apiService = NewsApiService.getInstance()
            try {
                val wsjNewsList = apiService.getWSJNews()
                wsjNewsResponse = wsjNewsList.articles
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getBloombergList() {
        viewModelScope.launch {
            val apiService = NewsApiService.getInstance()
            try {
                val bloombergNewsList = apiService.getBloombergNews()
                bloombergNewsResponse = bloombergNewsList.articles
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}