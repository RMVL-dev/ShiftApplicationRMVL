package com.example.shiftapplicationrmvl.data.utils

import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("uuid")
    val id:String,
    @SerializedName("username")
    val userName:String,
    @SerializedName("password")
    val password:String,
    @SerializedName("salt")
    val salt:String,
    @SerializedName("md5")
    val md5:String,
    @SerializedName("sha1")
    val sha1:String,
    @SerializedName("sha256")
    val sha256:String,
)