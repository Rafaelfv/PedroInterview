package com.pokeapi.pedrointerview.data.serviceData

import com.pokeapi.pedrointerview.data.ApiChuck
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class CategoriesServiceDataSource @Inject constructor(@Named("ApiChuck") private val api: ApiChuck)  {

    suspend fun getResponseList(): Response<List<String>> {
        return api.getListCategories()
    }

}