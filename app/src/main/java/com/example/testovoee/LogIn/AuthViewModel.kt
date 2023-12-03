package com.example.testovoee.LogIn

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testovoee.API.API
import com.example.testovoee.Utils.SaveToken
import com.example.testovoee.entities.LogIn.LogIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel(repo: API) : ViewModel() {

    val repo = repo

    var token = MutableLiveData<String?>("")
    val responseError = MutableLiveData<String?>(null)
    private val saveToken = SaveToken()

    fun auth(authRepo: LogIn, storage: SharedPreferences) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repo.authRepo.authLogIn(authRepo)
            CoroutineScope(Dispatchers.Main).launch {
                token.value = response.body()?.response?.token
                saveToken.saveToken(token.value, storage )
                responseError.value = response.body()?.error?.error_msg
            }
        }
    }
}