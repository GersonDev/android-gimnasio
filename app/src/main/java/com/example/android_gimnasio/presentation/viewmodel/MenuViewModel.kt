package com.example.android_gimnasio.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_gimnasio.domain.models.People
import com.example.android_gimnasio.domain.repositories.PeopleRepository
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {

    private val peopleRepository=PeopleRepository()

    private val _nombre = MutableLiveData("")
    val nombre: LiveData<String> = _nombre
    private val _correo = MutableLiveData("")
    val correo: LiveData<String> = _correo
    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _listOfPeople = MutableLiveData<List<People>>(listOf())
    val listOfPeople: LiveData<List<People>> = _listOfPeople


    fun enviarNombre(nombre: String){
        _nombre.value = nombre
    }
    fun enviarCorreo(correo: String){
        _correo.value = correo
    }
    fun enviarPassword(password: String){
        _password.value = password
    }
    fun insertPeople(context: Context){
        viewModelScope.launch {
            peopleRepository.insertPeople(context, People(0,_nombre.value ?:"",_correo.value ?:"",_password.value ?:""))
        }
    }
    fun getPeople(context: Context){
        viewModelScope.launch {
            _listOfPeople.value = peopleRepository.getAllPeople(context)
        }
    }
}