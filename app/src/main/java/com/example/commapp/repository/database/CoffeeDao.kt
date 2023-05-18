package com.example.commapp.repository.database

import androidx.room.*
import com.example.commapp.repository.database.model.Coffee
import com.example.commapp.repository.database.model.FavoriteCoffee
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeeDao {

    @Query("SELECT * from coffee")
    fun loadAll() : Flow<List<Coffee>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<Coffee>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(coffee: Coffee)

    @Delete
    suspend fun delete(coffee: Coffee)

    @Query("SELECT COUNT(*) from coffee")
    suspend fun getCount() : Int

    @Query("UPDATE coffee SET favorite = CASE " +
            "WHEN favorite = true THEN false " +
            "ELSE true " +
            "END " +
            "WHERE id = :id AND type = :type")
    suspend fun updateFavorite(id: Int, type: String)

    @Query("SELECT name, favorite from coffee")
    fun loadFavorite() : Flow<List<FavoriteCoffee>>
}