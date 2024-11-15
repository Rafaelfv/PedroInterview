package com.pokeapi.pedrointerview.data.useCase

import com.pokeapi.pedrointerview.data.repository.CategoryRepository
import javax.inject.Inject

class CategoryUsecase@Inject constructor(private val repository: CategoryRepository)  {


    suspend fun getListCategories(): List<String> {
        return repository.getListCategories()
    }
}