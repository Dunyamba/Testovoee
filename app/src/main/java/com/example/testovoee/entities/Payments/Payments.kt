package com.example.testovoee.entities.Payments

import com.google.gson.annotations.SerializedName

data class Payments(
   @SerializedName("response") val response: List<ResponseX>,
   @SerializedName("success") val success: String
)