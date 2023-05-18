package com.example.commapp.repository.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private val BASE_URL = "https://api.sampleapis.com"
        private val instance by lazy {
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val coffeeClient = instance.create(CoffeeService::class.java)
    }
}