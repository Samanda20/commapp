package com.example.commapp.repository

import android.app.Application
import com.example.commapp.repository.database.CoffeeDatabase
import com.example.commapp.repository.database.model.Coffee
import com.example.commapp.repository.remote.RetrofitClient

class CoffeeRepository(application: Application) {
    private val database : CoffeeDatabase by lazy { CoffeeDatabase.getDatabase(application) }

    //database
    suspend fun getCount() = database.coffeeDao().getCount()
    fun getData() = database.coffeeDao().loadAll()
    suspend fun updateFav(id: Int, type: String) = database.coffeeDao().updateFavorite(id, type)
    suspend fun insertAll(list: List<Coffee>) = database.coffeeDao().insertList(list)
    fun getFavoriteData() = database.coffeeDao().loadFavorite()

    //remote
    suspend fun fetchHotCoffeeData() = RetrofitClient.coffeeClient.getHotCoffeeList()
    suspend fun fetchIcedCoffeeData() = RetrofitClient.coffeeClient.getIcedCoffeeList()
}