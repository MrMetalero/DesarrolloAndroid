package com.apli.todoapp.todo

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel:ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username


    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnabled: LiveData<Boolean> = _isLoginEnabled


    fun onLoginChange(email: String, password: String){
        _email.value = email
        _password.value = password
        _isLoginEnabled.value = enableLogin(email,password)



    }


    private fun enableLogin(email:String, password:String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 8





    }
}