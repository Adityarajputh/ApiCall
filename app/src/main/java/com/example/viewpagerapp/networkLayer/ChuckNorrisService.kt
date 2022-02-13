package com.example.viewpagerapp.networkLayer

import com.example.viewpagerapp.dataclass.JokeResponse
import com.example.viewpagerapp.dataclass.CategoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChuckNorrisService {

    @GET("random")
    suspend fun getJoke() : Response<JokeResponse>

    @GET("categories")
    suspend fun getCategories() : Response<CategoryResponse>

    @GET("random")
    suspend fun getCategoryJoke(@Query("category") categoryName : String)
                            : Response<JokeResponse>

}