package com.example.testovoee.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "https://easypay.world/api-test/"

object API {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val authRepo: AuthRepo = retrofit.create(AuthRepo::class.java)
    val paymentsRepo: GetPaymentsRepo = retrofit.create(GetPaymentsRepo::class.java)

}

