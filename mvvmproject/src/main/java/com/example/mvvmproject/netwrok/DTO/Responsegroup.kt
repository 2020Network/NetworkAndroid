package com.example.mvvmproject.netwrok.DTO

data class Responsegroup (
    val code : Int,
    val message : String,
    val groupInfo : ArrayList<com.example.mvvmproject.netwrok.DTO.Group>
    )