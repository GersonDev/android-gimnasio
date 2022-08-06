package com.example.android_gimnasio.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.android_gimnasio.data.database.entities.PeopleEntity


@Dao
interface
PeopleDao {
    @Query("SELECT * FROM people")
    suspend fun getPeople(): List<PeopleEntity>

    @Insert
    suspend fun insertPeople(peopleEntity: PeopleEntity):Long

    @Update
    suspend fun updatePeople(peopleEntity: PeopleEntity)
}