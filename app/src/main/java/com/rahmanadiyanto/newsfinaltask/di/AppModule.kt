package com.rahmanadiyanto.newsfinaltask.di

import com.google.gson.GsonBuilder
import com.rahmanadiyanto.newsfinaltask.data.remote.NewsApi
import com.rahmanadiyanto.newsfinaltask.data.repository.NewsRepositoryImpl
import com.rahmanadiyanto.newsfinaltask.domain.repository.NewsRepository
import com.rahmanadiyanto.newsfinaltask.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiKeyInterceptor(): Interceptor{
        return Interceptor{ chain ->
            val request = chain.request().newBuilder()
            chain.proceed(request.build())
        }
    }

    @Provides
    @Singleton
    fun provideClient(apiKeyInterceptor:Interceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    //Retrofit2
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient):NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client)
            .build()
            .create(NewsApi::class.java)
    }

    //Repository
    @Provides
    @Singleton
    fun provideNewsRepository(newsApi:NewsApi):NewsRepository{
         return NewsRepositoryImpl(api=newsApi)
    }

}