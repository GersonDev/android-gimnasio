package com.example.android_gimnasio.domain.repositories

import android.content.Context
import com.example.android_gimnasio.data.datasources.DatabaseDataSource
import com.example.android_gimnasio.data.datasources.RemoteDataSource
import com.example.android_gimnasio.domain.models.People
import com.example.android_gimnasio.domain.models.gym.Brand
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PeopleRepository {
    private val databaseDataSource = DatabaseDataSource()
    private val remoteDataSource = RemoteDataSource()

    suspend fun getAllPeople(context: Context): List<People> {
        return withContext(Dispatchers.IO) {
            databaseDataSource.getAllPeople(context)
        }
    }

    suspend fun insertPeople(context: Context, people: People): Long {
        return withContext(Dispatchers.IO) {
            databaseDataSource.insertPeople(context, people)
        }
    }

    suspend fun updatePeople(context: Context, people: People) {
        return withContext(Dispatchers.IO) {
            databaseDataSource.updatePeople(context, people)
        }
    }

    suspend fun getBrandsFromRemote(): List<Brand> {
        return withContext(Dispatchers.IO) {
            remoteDataSource.getUsersFromRemote()
        }
    }

}