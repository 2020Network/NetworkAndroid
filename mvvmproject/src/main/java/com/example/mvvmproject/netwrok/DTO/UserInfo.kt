package com.example.mvvmproject.netwrok.DTO

import com.google.gson.annotations.SerializedName

data class UserInfo (
    val UserID : Int,
    val UserName :String,
    val UserEmail :String,
    val UserPwd :String,
    val Age :String,
    val Gender :String,
    val StudyField :String
)