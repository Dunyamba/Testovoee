package com.example.testovoee.LogIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testovoee.API.API
import com.example.testovoee.API.AuthRepo

class AuthVMFactory: ViewModelProvider.Factory {

    val repo = API

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(repo = repo) as T
    }
}