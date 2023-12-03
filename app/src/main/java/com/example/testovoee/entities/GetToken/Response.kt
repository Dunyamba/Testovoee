package com.example.testovoee.entities.GetToken

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("token") val token: String
)