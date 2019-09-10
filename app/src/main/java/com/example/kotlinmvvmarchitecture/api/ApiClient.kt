package com.example.kotlinmvvmarchitecture.api

import com.example.kotlinmvvmarchitecture.BuildConfig
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var BASE_URL: String

    val instance: ApiServices = Retrofit.Builder().run {

        BASE_URL = if (BuildConfig.DEBUG) {
            "https://api.github.com/"
//        "http://sbdtrickstutorials.co.in/homesfresh_api/api/"
        } else {
            "https://api.github.com/"
//        "http://spamassagepro.co.in/homesfresh_api/api/"
        }
        val gson = GsonBuilder()
            .enableComplexMapKeySerialization()
            .setPrettyPrinting()
            .create()
        baseUrl(BASE_URL)
        addConverterFactory(GsonConverterFactory.create(gson))
        build()
    }.create(ApiServices::class.java)
}