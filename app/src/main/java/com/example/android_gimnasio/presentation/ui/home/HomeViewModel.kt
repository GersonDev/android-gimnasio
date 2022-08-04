package com.example.android_gimnasio.presentation.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_gimnasio.R
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

    private val _userName = MutableLiveData("")
    val userName: LiveData<String> = _userName

    // perfil livedatas
    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email
    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _busInfoList = MutableLiveData<List<Bus>>(listOf(
        Bus(
            "0",
            latitude = -11.967750655284977,
            longitude = -77.00428152896053,
            imagen = R.drawable.ic_megaforce
        ),
        Bus(
            "1",
            latitude = -11.969140970527766,
            longitude = -77.00511967818196,
            imagen = R.drawable.ic_megaforce
        ),
        Bus(
            "2",
            latitude = -11.971885930945978,
            longitude = -77.00670487345754,
            imagen = R.drawable.ic_megaforce
        ),
        Bus(
            "3",
            latitude = -11.974862577286663,
            longitude = -77.00885490842902,
            imagen = R.drawable.ic_megaforce
        )
    ))
    val busInfoList: LiveData<List<Bus>> = _busInfoList

    private val _currentBusStop = MutableLiveData<BusStop>(BusStop(-11.967750655284977, -77.00428152896053, "My Bus"))
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

    // TODO: GERSON porfa agregar el campo nombre en la table y pintarlo en la pantalla HOME
    fun getUsers(context: Context) {
        viewModelScope.launch {
            val peopleList = peopleRepository.getAllPeople(context)
            val personaEncontrada = peopleList.first()
            _userName.value = personaEncontrada.email
        }
    }

}