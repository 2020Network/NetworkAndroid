package com.example.mvvmproject.netwrok.DTO

data class GroupRequest(
    val title : String,
    val content : String,
    val people : Int,
    val location : String,
    val gender : String,
    val age1 : String,
    val age2 : String,
    val studyField : String,
    val userID : Int
)