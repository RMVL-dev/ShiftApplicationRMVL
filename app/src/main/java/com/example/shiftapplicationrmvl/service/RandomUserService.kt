package com.example.shiftapplicationrmvl.service

import com.example.shiftapplicationrmvl.data.UsersData
import retrofit2.http.GET

interface RandomUserService {

    @GET
    suspend fun getRandomUser(): UsersData

}