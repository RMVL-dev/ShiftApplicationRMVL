package com.example.shiftapplicationrmvl.data.converter

import com.example.shiftapplicationrmvl.data.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    private val gson by lazy { Gson() }

    fun listToJson(data:List<User>):String? =
        try {
            gson.toJson(data)
        }catch (e:Exception){
            null
        }

    fun listFromJson(data:String?):List<User>?{
        if (data == null)
            return null

        val type = object: TypeToken<List<User>>() {}.type

        return try {
            gson.fromJson(data, type)
        }catch (e:Exception){
            null
        }

    }

    fun toJson(data:User):String? =
        try {
            gson.toJson(data)
        }catch (e:Exception){
            null
        }

    fun fromJson(data: String?): User? {

        data ?: return null

        val type = object : TypeToken<User>() {}.type

        return try {
            gson.fromJson(data, type)
        }catch (e:Exception){
            null
        }
    }

}