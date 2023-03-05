package com.rahmanadiyanto.newsfinaltask.data.repository

import com.rahmanadiyanto.newsfinaltask.data.remote.NewsApi
import com.rahmanadiyanto.newsfinaltask.data.remote.model.Article
import com.rahmanadiyanto.newsfinaltask.domain.repository.NewsRepository
import com.rahmanadiyanto.newsfinaltask.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRepositoryImpl(private val api:NewsApi):NewsRepository {

    override suspend fun getNews(
        q: String,
        searchIn: String,
        apiKey: String
    ): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading("Loading"))
        val result = api.getNews(q, searchIn, apiKey)
        emit(Resource.Success(result.articles))
    }.flowOn(Dispatchers.IO)
}