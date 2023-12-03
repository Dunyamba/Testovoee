package com.example.testovoee.Utils

import android.content.SharedPreferences
import android.util.Log

const val SAVED_TOKEN = ""

class SaveToken {

    fun saveToken(token: String?, storage: SharedPreferences): String? {
        storage.edit().putString(SAVED_TOKEN, token).apply()
        return token
    }

    fun getSavedToken(storage: SharedPreferences): String? {
        val token = storage.getString(SAVED_TOKEN, "")
        return token
    }

    fun deleteToken(storage: SharedPreferences){
        storage.edit().remove(SAVED_TOKEN).apply()
    }
}