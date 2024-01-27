package com.example.shiftapplicationrmvl.data.repository

import com.example.shiftapplicationrmvl.data.UsersData
import com.example.shiftapplicationrmvl.service.RandomUserService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: RandomUserService
):ShiftRepository {
    override suspend fun getUsers(): UsersData =
        service.getRandomUser()
}