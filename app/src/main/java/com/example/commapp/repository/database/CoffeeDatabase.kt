package com.example.commapp.repository.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.commapp.repository.database.model.Coffee

@Database(version = 1, entities = [Coffee::class], exportSchema = false)
abstract class CoffeeDatabase : RoomDatabase() {
    abstract fun coffeeDao() : CoffeeDao

    companion object {
        private var instance : CoffeeDatabase? = null
        fun getDatabase(application: Application) : CoffeeDatabase {
            return instance?: Room.databaseBuilder(application,
                CoffeeDatabase::class.java,
                "coffee-database").build()
        }
    }
}