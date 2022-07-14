package com.example.android_gimnasio.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class PeopleEntity(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "correo")val correo: String,
    @ColumnInfo(name = "password")val password: String
)