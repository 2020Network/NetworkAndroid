package com.example.mvvmproject.netwrok.DTO

data class ResponseMygroup(
    val code : Int,
    val message : String,
    val groupInfo : ArrayList<MyGroup>
)
