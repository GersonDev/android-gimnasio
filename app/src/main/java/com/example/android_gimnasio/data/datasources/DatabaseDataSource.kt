package com.example.android_gimnasio.data.datasources

import android.content.Context
import com.example.android_gimnasio.data.database.GimnasioDataBase
import com.example.android_gimnasio.data.database.entities.PeopleEntity
import com.example.android_gimnasio.domain.models.People

class DatabaseDataSource {
    suspend fun getAllPeople(context: Context): List<People> {
        val listPeopleEntities = GimnasioDataBase.buildDataBase(context)
            .peopleDao()
            .getPeople()
        return listPeopleEntities.map {
            People(
                id = it.id,
                nombre = it.nombre,
                correo = it.correo,
                password = it.password
            )
        }
    }

    suspend fun insertPeople(context: Context, people: People) {
        val peopleEntity = PeopleEntity(
            id = people.id,
            nombre = people.nombre,
            correo = people.correo,
            password = people.password
        )
        GimnasioDataBase.buildDataBase(context)
            .peopleDao()
            .insertPeople(peopleEntity)
    }
}