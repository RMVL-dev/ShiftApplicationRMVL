package com.example.shiftapplicationrmvl.data.responseState

import com.example.shiftapplicationrmvl.data.UsersData

sealed interface ResponseState{

    data class Success(val usersData: UsersData):ResponseState

    object Error:ResponseState

    object Loading:ResponseState
}