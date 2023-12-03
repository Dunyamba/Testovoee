package com.example.testovoee.ScreenWithPays

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testovoee.API.API
import com.example.testovoee.API.GetPaymentsRepo

class PaymentsVMFactory: ViewModelProvider.Factory {
    val repo = API
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListPaysViewModel(repo) as T
    }
}