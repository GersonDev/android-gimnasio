package com.example.android_gimnasio.domain.repositories

import android.content.Context
import com.example.android_gimnasio.data.datasources.DatabaseDataSource
import com.example.android_gimnasio.domain.models.People
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PeopleRepository {
    private val databaseDataSource = DatabaseDataSource()

    suspend fun getAllPeople(context: Context): List<People> {
        return withContext(Dispatchers.IO) {
            databaseDataSource.getAllPeople(context)
        }
    }

    suspend fun insertPeople(context: Context, people: People) {
        return withContext(Dispatchers.IO) {
            databaseDataSource.insertPeople(context, people)
        }
    }
}