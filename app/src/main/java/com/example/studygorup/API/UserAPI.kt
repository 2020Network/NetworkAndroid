package com.example.studygorup.API

import com.example.studygorup.DTO.Login
import com.example.studygorup.DTO.Responselogin
import com.example.studygorup.DTO.Responsesign
import com.example.studygorup.DTO.Signup
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {
    @POST("/user/join")
    fun signUp(
        @Body signup : Signup
    ) : Call<Responsesign>

    @POST("/user/login")
    fun login(
        @Body login: Login
    ) : Call<Responselogin>
}