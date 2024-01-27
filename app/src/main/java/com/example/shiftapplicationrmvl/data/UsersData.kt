package com.example.shiftapplicationrmvl.data

import com.example.shiftapplicationrmvl.data.utils.DataInfo
import com.google.gson.annotations.SerializedName

data class UsersData(
    @SerializedName("results")
    val results:List<User>,
    @SerializedName("info")
    val info: DataInfo
)
