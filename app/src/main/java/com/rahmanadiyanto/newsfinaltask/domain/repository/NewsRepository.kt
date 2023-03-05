package com.rahmanadiyanto.newsfinaltask.domain.repository

import com.rahmanadiyanto.newsfinaltask.data.remote.model.Article
import com.rahmanadiyanto.newsfinaltask.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(q:String,searchIn:String,apiKey:String): Flow<Resource<List<Article>>>
}