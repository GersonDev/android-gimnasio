package com.example.android_gimnasio.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    private val _correo = MutableLiveData ("")
    val correo:LiveData<String> = _correo
    private val _password = MutableLiveData("")
    val password :LiveData<String> = _password

    fun enviarCorreo(correo:String){
        _correo.value=correo
    }
    fun enviarPassword(password:String){
        _password.value = password
    }

}