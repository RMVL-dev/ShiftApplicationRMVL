package com.example.shiftapplicationrmvl.data.utils

import com.google.gson.annotations.SerializedName

data class UserBirthday (
    @SerializedName("date")
    val date:String,
    @SerializedName("age")
    val age:Int
)