package com.example.shiftapplicationrmvl.data.sharedPref

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import com.example.shiftapplicationrmvl.data.User
import com.example.shiftapplicationrmvl.data.converter.Converter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesReq @Inject constructor(
    context: Context
) {

    companion object{
        const val FILE_NAME = "users"
        private const val PREF_USERS_LIST = "pref_users_list"
    }

    private val sharedPref:SharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    var users: String?
        set(value) = sharedPref.edit{ putString(PREF_USERS_LIST, value) }
        get() = sharedPref.getString(PREF_USERS_LIST, "")
}