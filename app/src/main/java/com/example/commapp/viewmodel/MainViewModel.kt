package com.example.commapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.commapp.repository.CoffeeRepository
import com.example.commapp.repository.database.model.Coffee
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : CoffeeRepository by lazy { CoffeeRepository(application) }
    val coffeeList = repository.getData().asLiveData()

    init {
        viewModelScope.launch {
            if (repository.getCount() == 0) {
                var list = ArrayList<Coffee>()
                repository.fetchHotCoffeeData().forEach {
                    list.add(Coffee(it.id, "hot", it.title, it.description, it.image, false))
                }
                repository.fetchIcedCoffeeData().forEach {
                    list.add(Coffee(it.id, "iced", it.title, it.description, it.image, false))
                }
                repository.insertAll(list)
            }
        }
    }

    fun changeFavorite(viewId: Int, type: String) {
        viewModelScope.launch { repository.updateFav(viewId, type) }
    }
}