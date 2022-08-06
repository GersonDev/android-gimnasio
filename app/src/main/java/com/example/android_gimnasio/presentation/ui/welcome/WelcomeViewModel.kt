package com.example.android_gimnasio.presentation.ui.welcome

import android.app.Application
import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment.DIRECTORY_DOWNLOADS
import androidx.lifecycle.*
import com.example.android_gimnasio.domain.models.People
import com.example.android_gimnasio.domain.repositories.PeopleRepository
import com.example.android_gimnasio.sharedpreferences.Preferences
import kotlinx.coroutines.launch

class WelcomeViewModel(application: Application) : AndroidViewModel(application) {

    private val peopleRepository = PeopleRepository()

    private val preferences = Preferences(application)

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email
    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password
    private val _confirmationPassword = MutableLiveData("")
    val confirmationPassword: LiveData<String> = _confirmationPassword

    private val _isLogin = MutableLiveData(false)
    val isLogin: LiveData<Boolean> = _isLogin

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
            val idGenerado = peopleRepository.insertPeople(
                context,
                People(
                    0,
                    _email.value ?: "",
                    _password.value ?: "",
                    _confirmationPassword.value ?: "",
                    estaLogeado = 1
                )
            )
            preferences.saveId(id = idGenerado.toInt())
            _registroExitoso.value = true
        }
    }


    fun startLogin(context: Context) {
        viewModelScope.launch {
            val todasLasPersonas = peopleRepository.getAllPeople(context)
            val personaEncontradaPorCorreoPassword=todasLasPersonas.first{
                it.email==_email.value && it.password==_password.value
            }
            preferences.saveId(personaEncontradaPorCorreoPassword.id)
            peopleRepository.updatePeople(
                context = context,
                people = People(
                    id = personaEncontradaPorCorreoPassword.id,
                    email =personaEncontradaPorCorreoPassword.email ,
                    password = personaEncontradaPorCorreoPassword.password,
                    confirmationPassword =personaEncontradaPorCorreoPassword.confirmationPassword ,
                    estaLogeado = 1
                )
            )
            _loginExitoso.value = personaEncontradaPorCorreoPassword != null
        }
    }

    fun verifyLogin(context: Context) {
        viewModelScope.launch {
            val peopleList = peopleRepository.getAllPeople(context)
            if (peopleList.size > 0) {
                val personaLogeada = peopleList.first()
                if (personaLogeada.estaLogeado == 1) {
                    _isLogin.value = true
                }
            }
        }
    }

    fun ocultarModal() {
        _loginExitoso.value = null
    }

    fun downloadFile(context: Context) {
        val uri: Uri =
            Uri.parse("https://download.samplelib.com/mp3/sample-3s.mp3") // Path where you want to download file.
        // Create request for android download manager
        // Create request for android download manager
        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val request: DownloadManager.Request = DownloadManager.Request(uri)
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI) // Tell on which network you want to download file.
        request.setTitle("calin" + "veamos"); // Title for notification.
        request.setVisibleInDownloadsUi(true);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);  // This will show notification on top when downloading the file.
        request.setDestinationInExternalPublicDir(DIRECTORY_DOWNLOADS, "downloadfileName.mp3")
        request.setMimeType("*/*")

//        val file= File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "noseee")
//        if(!file.exists()) file.mkdirs(); //make sure you have storage permission

        downloadManager.enqueue(request)

//        viewModelScope.launch {
//            manager.en
//        }

    }

    fun reiniciarRegistro() {
        _registroExitoso.value = false
        _email.value = ""
        _password.value = ""

    }

    fun reiniciarLogin() {
        _loginExitoso.value = null
    }
}