package com.pokeapi.pedrointerview.data.repository

import com.pokeapi.pedrointerview.data.JokeRespose
import com.pokeapi.pedrointerview.data.serviceData.CategoriesServiceDataSource
import com.pokeapi.pedrointerview.data.serviceData.JokeDataSource
import javax.inject.Inject

class JokeRepository @Inject constructor(
    private val jokeDataSource: JokeDataSource
) {

    suspend fun getJokesByCategory(category: String): JokeRespose? {
        return jokeDataSource.getJokeList(category).body()

    }
}