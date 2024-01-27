package com.example.shiftapplicationrmvl.data.repository

import com.example.shiftapplicationrmvl.data.UsersData

interface ShiftRepository {

    suspend fun getUsers():UsersData

}