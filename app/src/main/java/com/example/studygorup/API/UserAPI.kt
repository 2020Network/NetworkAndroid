package com.example.studygorup.API

import com.example.studygorup.DTO.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserAPI {
    @POST("/user/join")
    fun signUp(
        @Body signup : Signup
    ) : Call<Responsesign>

    @POST("/user/login")
    fun login(
        @Body login: Login
    ) : Call<Responselogin>

    @GET("/user/myuser")
    fun getUser(
        @Query("userID") userID : Int? = null
    ) : Call<ResponsemyUser>

    @POST("user/myuser/update")
    fun updateUser(
        @Body updateUser : myUserUpdate
    ) : Call<ResponseGroupID>
}