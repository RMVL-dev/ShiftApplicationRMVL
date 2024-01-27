package com.example.shiftapplicationrmvl.data.utils

import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("large")
    val largeUrl:String,
    @SerializedName("medium")
    val mediumUrl:String,
    @SerializedName("thumbnail")
    val thumbnail:String,
)