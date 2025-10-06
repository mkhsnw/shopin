package com.example.qpon_clone.remote.api

import com.example.qpon_clone.model.LoginRequest
import com.example.qpon_clone.model.LoginResponse
import com.example.qpon_clone.model.RegisterRequest
import com.example.qpon_clone.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest) : Response<LoginResponse>

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest) : Response<RegisterResponse>
}