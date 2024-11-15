package com.pokeapi.pedrointerview.data.useCase

import com.pokeapi.pedrointerview.data.JokeRespose
import com.pokeapi.pedrointerview.data.repository.JokeRepository
import javax.inject.Inject

class JokeByCategoryUsecase@Inject constructor(private val repository: JokeRepository) {

    suspend fun getJokesByCategory(category: String): JokeRespose? {
        return repository.getJokesByCategory(category)

    }
}