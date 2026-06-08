package com.example.aulia_core.data.api

import com.example.aulia_core.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BeritaApiService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "id",
        @Query("apiKey") apiKey: String = "3f6d2fbad72a472692d5d2a48cc4f3ab"
    ): NewsResponse
}