package com.example.shiftapplicationrmvl.data

import com.example.shiftapplicationrmvl.data.utils.Location
import com.example.shiftapplicationrmvl.data.utils.LoginData
import com.example.shiftapplicationrmvl.data.utils.Picture
import com.example.shiftapplicationrmvl.data.utils.RegisterDate
import com.example.shiftapplicationrmvl.data.utils.UserBirthday
import com.example.shiftapplicationrmvl.data.utils.UserID
import com.example.shiftapplicationrmvl.data.utils.UserName
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("gender")
    val gender:String,
    @SerializedName("name")
    val name:UserName,
    @SerializedName("location")
    val location:Location,
    @SerializedName("email")
    val email:String,
    @SerializedName("login")
    val loginData: LoginData,
    @SerializedName("dob")
    val dateOfBirthday: UserBirthday,
    @SerializedName("registered")
    val registerDate: RegisterDate,
    @SerializedName("phone")
    val phoneNumber:String,
    @SerializedName("cell")
    val cellNumber:String,
    @SerializedName("id")
    val userID: UserID,
    @SerializedName("picture")
    val picture: Picture,
    @SerializedName("nat")
    val national:String
)