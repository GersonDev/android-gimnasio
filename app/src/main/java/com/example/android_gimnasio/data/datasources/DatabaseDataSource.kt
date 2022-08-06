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
                email = it.correo,
                password = it.password,
                confirmationPassword = it.confirmationPassword,
                estaLogeado = it.cerrarSesion
            )
        }
    }

    suspend fun insertPeople(context: Context, people: People): Long {
        val peopleEntity = PeopleEntity(
            id = people.id,
            correo = people.email,
            password = people.password,
            confirmationPassword = people.confirmationPassword,
            cerrarSesion = people.estaLogeado
        )
        val idGenerado = GimnasioDataBase
            .buildDataBase(context)
            .peopleDao()
            .insertPeople(peopleEntity)
        return idGenerado
    }

    suspend fun updatePeople(context: Context, people: People) {
        val peopleEntity = PeopleEntity(
            id = people.id,
            correo = people.email,
            password = people.password,
            confirmationPassword = people.confirmationPassword,
            cerrarSesion = people.estaLogeado
        )
        GimnasioDataBase.buildDataBase(context)
            .peopleDao()
            .updatePeople(peopleEntity)

    }
}