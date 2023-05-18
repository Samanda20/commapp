package com.example.commapp.repository.remote.response

import com.google.gson.annotations.SerializedName

data class CoffeeResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("ingredients") val ingredients: List<String>,
    @SerializedName("image") val image: String)
