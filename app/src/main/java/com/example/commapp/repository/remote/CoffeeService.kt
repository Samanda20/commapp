package com.example.commapp.repository.remote

import com.example.commapp.repository.remote.response.CoffeeResponse
import retrofit2.http.GET

interface CoffeeService {

    @GET("/coffee/hot")
    suspend fun getHotCoffeeList() : List<CoffeeResponse>

    @GET("/coffee/iced")
    suspend fun getIcedCoffeeList() : List<CoffeeResponse>
}