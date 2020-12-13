package com.example.studygorup.DTO

data class ResponseJoinGroup(
    val code : Int,
    val message : String,
    val groupInfo : ArrayList<MyJoinGroup>
)
