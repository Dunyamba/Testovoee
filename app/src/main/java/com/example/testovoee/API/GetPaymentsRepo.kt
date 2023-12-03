package com.example.testovoee.API

import com.example.testovoee.entities.Payments.Payments
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface GetPaymentsRepo {

    @Headers(
        "app-key:12345",
        "v:1",
//        "token: 7b7c0a690bee2e8d90512ed1b57e19f0"
    )
    @GET("payments")
    fun getPayments(@Header("token") token: String?): Call<Payments>
}

//@Header("Authorization") token: String