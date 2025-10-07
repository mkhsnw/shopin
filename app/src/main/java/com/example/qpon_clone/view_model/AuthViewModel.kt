package com.example.qpon_clone.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qpon_clone.data.model.LoginRequest
import com.example.qpon_clone.data.model.LoginResponse
import com.example.qpon_clone.data.model.RegisterRequest
import com.example.qpon_clone.data.model.RegisterResponse
import com.example.qpon_clone.remote.RetrofitInstance
import com.example.qpon_clone.remote.api.AuthService
import com.example.qpon_clone.remote.Result
import kotlinx.coroutines.launch

class AuthViewModel (
    private val authService: AuthService = RetrofitInstance.authService
) : ViewModel() {

    private val _loginResponse = MutableLiveData<Result<LoginResponse>>()
    val loginResponse: LiveData<Result<LoginResponse>> = _loginResponse

    private val _registerResponse = MutableLiveData<Result<RegisterResponse>>()
    val registerResponse : LiveData<Result<RegisterResponse>> = _registerResponse

    fun login(email: String, password: String) {
        _loginResponse.value = Result.Loading
        viewModelScope.launch {
            try {
                val request = LoginRequest(email = email, password = password)
                val response = authService.login(request)

                if (response.isSuccessful) {
                    response.body()?.let {
                        _loginResponse.value = Result.Success(it)
                        Log.i("AuthViewModel", "Login successful: $it")
                    } ?: run {
                        _loginResponse.value = Result.Error(Exception("Empty response body"))
                        Log.e("AuthViewModel", "Login failed: Empty response body")
                    }
                }else{
                    _loginResponse.value = Result.Error(Exception("Login failed with code: ${response.code()}"))
                    Log.e("AuthViewModel", "Login failed with code: ${response.code()}")
                }
            } catch (e: Exception){
                _loginResponse.value = Result.Error(e)
                Log.i("AuthViewModel", "Login error: ${e.localizedMessage}")
            }
        }
    }

    fun register(name: String, email: String, password: String) {
        _registerResponse.value = Result.Loading
        viewModelScope.launch {
            try {
                val request = RegisterRequest(name,email,password)
                val response = authService.register(request)
                if(response.isSuccessful) {
                    response.body()?.let {
                        _registerResponse.value = Result.Success(it)

                    } ?: run {
                        _registerResponse.value = Result.Error(Exception("Empty Response Body"))
                        Log.e("AuthViewModel", "Register failed: Empty response body")
                    }
                }
            }catch (e: Exception) {
                _registerResponse.value = Result.Error(e)
                Log.e("AuthViewModel", "Register error: ${e.localizedMessage}")
            }
        }
    }
}