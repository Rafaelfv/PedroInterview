package com.pokeapi.pedrointerview.data.repository

import com.pokeapi.pedrointerview.data.serviceData.CategoriesServiceDataSource
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val apiListCsategories: CategoriesServiceDataSource
) {

    suspend fun getListCategories(): List<String> {
        val a = apiListCsategories.getResponseList().body()
        return a ?: listOf()
    }
}