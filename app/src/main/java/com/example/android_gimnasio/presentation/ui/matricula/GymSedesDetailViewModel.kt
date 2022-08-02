package com.example.android_gimnasio.presentation.ui.matricula

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

class GymSedesDetailViewModel:ViewModel() {
    private val _matriculaexitosa = MutableLiveData<Boolean>()
    var matriculaexitosa: LiveData<Boolean> = _matriculaexitosa

    fun startLogin(context: Context) {
        viewModelScope.launch {
            val regresarAPantalla =  {
            }
            _matriculaexitosa.value = regresarAPantalla != null
        }
    }

    fun ocultarModal() {
        _matriculaexitosa.value = null
    }
}