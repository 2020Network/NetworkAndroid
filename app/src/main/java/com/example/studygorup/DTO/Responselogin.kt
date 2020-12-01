package com.example.studygorup.DTO

data class Responselogin (
    val code : Int,
    val message : String,
    val userInfo : Signup
)