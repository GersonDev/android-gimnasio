package com.example.android_gimnasio.presentation.ui.matricula

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

class GymSedesDetailViewModel : ViewModel() {
    private val _matriculaexitosa = MutableLiveData<Boolean>()
    var matriculaexitosa: LiveData<Boolean> = _matriculaexitosa

    private val _textBotonMatricula = MutableLiveData<String>("Matricularse")
    var textBotonMatricula: LiveData<String> = _textBotonMatricula

    private val _enableButtonMatricular = MutableLiveData<Boolean>(true)
    var enableButtonMatricular: LiveData<Boolean> = _enableButtonMatricular

    fun startMatricula(context: Context) {
        viewModelScope.launch {
            _matriculaexitosa.value = true
        }
    }

    fun ocultarModal() {
        _matriculaexitosa.value = false
    }

    fun updateTextBotonMatricula(text: String) {
        _textBotonMatricula.value = text
    }

    fun updateEnableButton(isEnabled: Boolean) {
        _enableButtonMatricular.value = isEnabled
    }
}