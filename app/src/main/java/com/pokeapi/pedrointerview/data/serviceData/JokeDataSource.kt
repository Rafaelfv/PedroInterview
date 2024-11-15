package com.pokeapi.pedrointerview.data.serviceData

import com.pokeapi.pedrointerview.data.ApiChuck
import com.pokeapi.pedrointerview.data.JokeRespose
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class JokeDataSource @Inject constructor(@Named("ApiChuck") private val api: ApiChuck) {

    suspend fun getJokeList(category: String): Response<JokeRespose> {
        return api.getJokesByCategory(category)
    }
}