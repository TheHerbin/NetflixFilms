package com.example.netflixfilms.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private val client = OkHttpClient
        .Builder()
        .build()

    private val retrofit =Retrofit.Builder()
            .baseUrl("https://unogsng.p.rapidapi.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(SearchApi::class.java)


    fun buildService(): SearchApi {
        return retrofit
    }

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }
}
