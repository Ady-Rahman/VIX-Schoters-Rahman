package com.rahmanadiyanto.newsfinaltask.data.remote

import com.rahmanadiyanto.newsfinaltask.data.remote.model.News
import com.rahmanadiyanto.newsfinaltask.util.Constants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("/v2/everything")
    suspend fun getNews(
        @Query ("q") q:String = "university+education",
        @Query ("searchIn") searchIn:String = "title",
        @Query ("apiKey") apiKey:String = API_KEY
    ):News
}