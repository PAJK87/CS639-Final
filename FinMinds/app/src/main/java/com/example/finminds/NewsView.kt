package com.example.finminds

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NewsView : ViewModel() {
    var newsResponse:Array<NewsData.Articles> by mutableStateOf(arrayOf())
    var errorMessage: String by mutableStateOf("")
    private val TAG: String = NewsView::class.java.simpleName

    fun getNewsList() {
        viewModelScope.launch {
            val apiService = NewsApiService.getInstance()
            try {
                val newsList = apiService.getNews()
                Log.d(TAG, newsList.status)
                newsResponse = newsList.articles
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}