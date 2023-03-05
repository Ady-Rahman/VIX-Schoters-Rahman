package com.rahmanadiyanto.newsfinaltask.domain.usecases

import com.rahmanadiyanto.newsfinaltask.data.remote.model.Article
import com.rahmanadiyanto.newsfinaltask.domain.repository.NewsRepository
import com.rahmanadiyanto.newsfinaltask.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val repository: NewsRepository) {
    suspend operator fun invoke(
        q: String,
        searchIn: String,
        apiKey: String
    ): Flow<Resource<List<Article>>> = repository.getNews(q, searchIn, apiKey)
}