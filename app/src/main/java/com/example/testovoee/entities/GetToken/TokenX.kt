package com.example.testovoee.entities.GetToken

import com.example.testovoee.entities.GetToken.Response
import com.google.gson.annotations.SerializedName
import java.lang.Error

data class TokenX(
    @SerializedName ("response") val response: Response,
    @SerializedName ("success") val success: String,
    @SerializedName("error") val error: com.example.testovoee.entities.GetToken.Error
)