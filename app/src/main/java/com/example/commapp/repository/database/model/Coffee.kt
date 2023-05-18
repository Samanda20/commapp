package com.example.commapp.repository.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "coffee", primaryKeys = ["id", "type"])
data class Coffee (
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "image") val image : String,
    @ColumnInfo(name = "favorite") val favorite: Boolean
    )