package com.example.android_gimnasio.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_gimnasio.domain.models.People
import com.example.android_gimnasio.domain.repositories.PeopleRepository
import kotlinx.coroutines.launch
import com.example.android_gimnasio.domain.models.Bus
import com.example.android_gimnasio.domain.models.BusStop

class HomeViewModel : ViewModel() {

    private val peopleRepository = PeopleRepository()

    private val _tituloDeMarca = MutableLiveData("")
    val tituloDeMarca: LiveData<String> = _tituloDeMarca

    private val _imagenDeMarca = MutableLiveData(0)
    val imagenDeMarca: LiveData<Int> = _imagenDeMarca

    // perfil livedatas
    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email
    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _busInfoList = MutableLiveData<List<Bus>>(listOf())
    val busInfoList: LiveData<List<Bus>> = _busInfoList

    private val _currentBusStop = MutableLiveData<BusStop>()
    val currentBusStop: LiveData<BusStop> = _currentBusStop

    fun setTituloDeMarca(tituloDeMarca: String) {
        _tituloDeMarca.value = tituloDeMarca
    }

    fun setImagenDeMarca(imagenDeMarca: Int) {
        _imagenDeMarca.value = imagenDeMarca
    }

    fun enviarCorreo(email: String) {
        _email.value = email
    }

    fun enviarPassword(password: String) {
        _password.value = password
    }

    fun updatePeople(context: Context) {
        viewModelScope.launch {
            peopleRepository.updatePeople(
                context,
                People(
                    1,
                    _email.value ?: "",
                    _password.value ?: "",
                    _password.value ?: ""
                )
            )
        }
    }

}