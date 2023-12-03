package com.example.testovoee.entities.GetToken

import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("error_code")val error_code: Int,
    @SerializedName("error_msg")val error_msg: String?
)