package com.example.netflixfilms.api

import com.example.netflixfilms.modeles.Search
import com.example.netflixfilms.modeles.SearchResponse
import retrofit2.Response
import retrofit2.Call
import retrofit2.http.*
import java.util.List
import io.reactivex.Observable

public interface SearchApi {


    @GET("search")
    fun getSearch(@Query("query")query : String,
                  @Header("X-RapidAPI-Key") key: String = "7a7f383dacmsh607c4979e606936p19d928jsnd986a333ce55",
                  @Header("X-RapidAPI-Host") host: String = "https://unogsng.p.rapidapi.com".substringAfterLast('/')

    ): Observable<SearchResponse>



}