 package com.example.studygorup.DTO

data class ResponsemyUser(
    val code: Int,
    val message: String,
    val userInfo : ArrayList<UserInfo>
)