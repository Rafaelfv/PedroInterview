package com.pokeapi.pedrointerview.data

import com.google.gson.annotations.SerializedName

data class JokeRespose(
    @SerializedName("categories") var categories: ArrayList<String> = arrayListOf(),
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("icon_url") var iconUrl: String? = null,
    var id: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    var url: String? = null,
    var value: String? = null
)