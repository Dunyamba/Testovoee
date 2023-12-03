package com.example.testovoee.entities.Payments

import com.google.gson.annotations.SerializedName

data class ResponseX(
    @SerializedName("amount")val amount: Any?,
    @SerializedName("created") val created: Any?,
    @SerializedName("id") val id: Any?,
    @SerializedName("title") val title: Any?
)