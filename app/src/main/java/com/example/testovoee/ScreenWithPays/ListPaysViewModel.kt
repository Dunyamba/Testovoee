package com.example.testovoee.ScreenWithPays

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testovoee.API.API
import com.example.testovoee.entities.Payments.Payments
import com.example.testovoee.entities.Payments.ResponseX
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPaysViewModel(val repo: API) : ViewModel() {

    val listPayments = MutableLiveData<List<ResponseX>>()

    private val _token = MutableStateFlow<String?>("")
    val token = _token.asStateFlow()

    fun getToken(savedToken: String?){
        _token.value = savedToken

    }


     fun getList(){
         CoroutineScope(Dispatchers.IO).launch {
           val response = repo.paymentsRepo.getPayments(_token.value).execute()
             CoroutineScope(Dispatchers.Main).launch{
                 listPayments.value = response.body()?.response

             }

         }
    }

}