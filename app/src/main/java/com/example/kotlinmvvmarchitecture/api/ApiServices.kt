package com.example.kotlinmvvmarchitecture.api

import com.example.kotlinmvvmarchitecture.models.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("search/repositories")
    fun getRepoList(@Query("q") query: String): Call<Item>
}