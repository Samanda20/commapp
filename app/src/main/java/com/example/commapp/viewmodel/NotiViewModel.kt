package com.example.commapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.example.commapp.repository.CoffeeRepository
import com.example.commapp.repository.database.model.Coffee

class NotiViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CoffeeRepository by lazy { CoffeeRepository(application) }
    val notiList = repository.getFavoriteData().asLiveData()
}