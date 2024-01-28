package com.example.shiftapplicationrmvl.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shiftapplicationrmvl.data.repository.RepositoryImpl
import com.example.shiftapplicationrmvl.data.responseState.ResponseState
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val repositoryImpl: RepositoryImpl
):ViewModel() {

    private val _user = MutableLiveData<ResponseState>()
    val user: LiveData<ResponseState> get() = _user


    fun getRandomUser(){
        viewModelScope.launch {
            _user.value = ResponseState.Loading

            _user.value = try {
                ResponseState.Success(
                    usersData = repositoryImpl.getUsers()
                )
            }catch (e:Exception){
                ResponseState.Error
            }
        }
    }

}