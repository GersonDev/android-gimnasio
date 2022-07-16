package com.example.android_gimnasio.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_gimnasio.domain.models.People
import com.example.android_gimnasio.domain.repositories.PeopleRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val peopleRepository = PeopleRepository()

    private val _nombre = MutableLiveData("")
    val nombre: LiveData<String> = _nombre
    private val _correo = MutableLiveData("")
    val correo: LiveData<String> = _correo
    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _registroExitoso = MutableLiveData(false)
    val registroExitoso: LiveData<Boolean> = _registroExitoso

    private val _loginExitoso = MutableLiveData<Boolean>()
    val loginExitoso: LiveData<Boolean> = _loginExitoso

    fun enviarNombre(nombre: String) {
        _nombre.value = nombre
    }

    fun enviarCorreo(correo: String) {
        _correo.value = correo
    }

    fun enviarPassword(password: String) {
        _password.value = password
    }

    fun insertPeople(context: Context) {
        viewModelScope.launch {
            peopleRepository.insertPeople(context, People(0, _nombre.value ?: "", _correo.value ?: "", _password.value ?: ""))
            _registroExitoso.value = true
        }
    }

    fun startLogin(context: Context) {
        viewModelScope.launch {
            val peopleList = peopleRepository.getAllPeople(context)
            val personaEncontrada = peopleList.find {
                it.correo == _correo.value
            }
            _loginExitoso.value = personaEncontrada != null
        }
    }

    fun ocultarModal() {
        _loginExitoso.value = null
    }
}