package com.example.studygorup.DTO

data class ResponseMygroup(
    val code : Int,
    val message : String,
    val groupInfo : ArrayList<MyGroup>
)
