package com.rahmanadiyanto.newsfinaltask.screen.news

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahmanadiyanto.newsfinaltask.data.remote.model.Article
import com.rahmanadiyanto.newsfinaltask.domain.usecases.NewsUseCase
import com.rahmanadiyanto.newsfinaltask.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsUseCase: NewsUseCase) : ViewModel() {
    private var _news = mutableStateOf<Resource<List<Article>>?>(null)
    val news: State<Resource<List<Article>>?> get() = _news

    fun getNews(
        q: String,
        searchIn: String,
        apiKey: String
    ) {
        viewModelScope.launch {
            newsUseCase(q, searchIn, apiKey).collect {
                _news.value = it
            }
        }
    }
}