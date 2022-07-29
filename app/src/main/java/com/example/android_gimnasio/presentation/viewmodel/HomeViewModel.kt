package com.example.android_gimnasio.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_gimnasio.domain.models.Bus
import com.example.android_gimnasio.domain.models.BusStop

class HomeViewModel : ViewModel() {

    private val _tituloDeMarca = MutableLiveData("")
    val tituloDeMarca: LiveData<String> = _tituloDeMarca

    private val _imagenDeMarca = MutableLiveData(0)
    val imagenDeMarca: LiveData<Int> = _imagenDeMarca

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

}