package com.example.shiftapplicationrmvl.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shiftapplicationrmvl.data.User
import com.example.shiftapplicationrmvl.data.converter.Converter
import com.example.shiftapplicationrmvl.data.repository.RepositoryImpl
import com.example.shiftapplicationrmvl.data.responseState.ResponseState
import com.example.shiftapplicationrmvl.data.sharedPref.SharedPreferencesReq
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val repositoryImpl: RepositoryImpl,
    private val sharedPreferences: SharedPreferencesReq
):ViewModel() {

    private val _user = MutableLiveData<ResponseState>()
    val user: LiveData<ResponseState> get() = _user

    private val _listOfUsers = MutableLiveData<List<User>>()
    val listOfUsers: LiveData<List<User>> get() = _listOfUsers


    fun getRandomUser(){
        viewModelScope.launch {
            _user.value = ResponseState.Loading

            _user.value = try {
                val response = repositoryImpl.getUsers()
                ResponseState.Success(
                    usersData = response
                )
            }catch (e:Exception){
                ResponseState.Error
            }

            if (_user.value is ResponseState.Success){
                val converter = Converter()
                var list = converter.listFromJson(sharedPreferences.users)?.toMutableList()
                if (list == null){
                    list = mutableListOf()
                }
                list.add((_user.value as ResponseState.Success).usersData.results.first())
                list.toList()
                sharedPreferences.users = converter.listToJson(list)
            }
        }
    }

    fun getAllUsers(){
        val list:List<User> = Converter().listFromJson(sharedPreferences.users) ?: emptyList()
        _listOfUsers.value = list
    }

}