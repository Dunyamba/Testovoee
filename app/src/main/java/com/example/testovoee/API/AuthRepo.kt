package com.example.testovoee.API

import com.example.testovoee.entities.LogIn.LogIn
import com.example.testovoee.entities.GetToken.TokenX
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthRepo {

    @Headers("app-key:12345", "v:1")
    @POST("login")
    suspend fun authLogIn(
        @Body logAndPass: LogIn
    ): Response<TokenX>
}