package com.example.mvvmproject.netwrok.DTO

data class MyGroup(
    val GroupID : Int ?= null,
    val Title : String,
    val Content : String,
    val People : Int,
    val Location : String,
    val Gender : String,
    val Age1 : String,
    val Age2 : String,
    val StudyField : String,
    val UserID : Int
)
