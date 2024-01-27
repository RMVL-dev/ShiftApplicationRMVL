package com.example.shiftapplicationrmvl.data.utils

import com.google.gson.annotations.SerializedName

data class UserID(
    @SerializedName("name")
    val name:String,
    @SerializedName("value")
    val value: String
)
