package com.example.android_gimnasio.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_gimnasio.data.database.dao.PeopleDao
import com.example.android_gimnasio.data.database.entities.PeopleEntity


@Database(entities = [PeopleEntity::class], version = 1, exportSchema = false)
abstract class GimnasioDataBase : RoomDatabase() {

    abstract fun peopleDao(): PeopleDao

    companion object {
        fun buildDataBase(context: Context): GimnasioDataBase {
            return Room.databaseBuilder(context, GimnasioDataBase::class.java, "GimnasioDataBase")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}