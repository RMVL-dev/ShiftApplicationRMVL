package com.example.shiftapplicationrmvl.data.utils

import com.google.gson.annotations.SerializedName

data class DataInfo(
    @SerializedName("seed")
    val seed:String,
    @SerializedName("results")
    val results:Int,
    @SerializedName("page")
    val page:Int,
    @SerializedName("version")
    val version:String
)