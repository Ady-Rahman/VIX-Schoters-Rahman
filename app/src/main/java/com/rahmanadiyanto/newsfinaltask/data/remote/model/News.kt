package com.rahmanadiyanto.newsfinaltask.data.remote.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)