package com.pokeapi.pedrointerview.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiChuck {

    @Headers("Accept: application/json")
    @GET("jokes/categories")
    suspend fun getListCategories(): Response<List<String>>


    @Headers("Accept: application/json")
    @GET("jokes/random")
    suspend fun getJokesByCategory( @Query("category") category: String ): Response<JokeRespose>
}