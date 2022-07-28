package com.example.android_gimnasio.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_gimnasio.domain.models.People
import com.example.android_gimnasio.domain.repositories.PeopleRepository
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {

    private val peopleRepository = PeopleRepository()

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email
    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password
    private val _confirmationPassword = MutableLiveData("")
    val confirmationPassword: LiveData<String> = _confirmationPassword
    private  val _isLogin = MutableLiveData(false)
    val isLogin : LiveData<Boolean> = _isLogin

    private val _registroExitoso = MutableLiveData(false)
    val registroExitoso: LiveData<Boolean> = _registroExitoso

    private val _loginExitoso = MutableLiveData<Boolean>()
    val loginExitoso: LiveData<Boolean> = _loginExitoso

    fun enviarCorreo(email: String) {
        _email.value = email
    }

    fun enviarPassword(password: String) {
        _password.value = password
    }

    fun enviarConfirmationPassword(nombre: String) {
        _confirmationPassword.value = nombre
    }

    fun insertPeople(context: Context) {
        viewModelScope.launch {
            peopleRepository.insertPeople(
                context,
                People(
                    0,
                    _email.value ?: "",
                    _password.value ?: "",
                    _confirmationPassword.value ?: ""
                )
            )
            _registroExitoso.value = true
        }
    }


    fun startLogin(context: Context) {
        viewModelScope.launch {
            val peopleList = peopleRepository.getAllPeople(context)
            val personaEncontrada = peopleList.find {
                it.email == _email.value
            }
            _loginExitoso.value = personaEncontrada != null
        }
    }

    fun verifyLogin(context: Context) {
        viewModelScope.launch {
            val peopleList = peopleRepository.getAllPeople(context)
            if (peopleList.size > 0) {
                _isLogin.value = true
            }
        }


    }

    fun ocultarModal() {
        _loginExitoso.value = null
    }
}