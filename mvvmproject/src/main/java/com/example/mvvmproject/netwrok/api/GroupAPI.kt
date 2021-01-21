package com.example.mvvmproject.netwrok.api

import com.example.mvvmproject.netwrok.DTO.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface GroupAPI {
    @POST("/group/create")
    fun create(
        @Body group : GroupRequest
    ) : Call<Responsesign>

    @GET("/group")
    fun allgroup( ) : Call<Responsegroup>

    @GET("/group/mygroup")
    fun mygroup(
        @Query("userID") userID : Int? = null
    ) : Call<ResponseMygroup>
    @GET("/group/allgroup")
    fun yougroup(
        @Query("groupID") groupID : Int? = null
    ) : Call<ResponseMygroup>

    @POST("/group/mygroup/update")
    fun mygroupUpdate(
        @Body update : GroupUpdate
    ) : Call<ResponseGroupID>

    @POST("/group/join")
    fun groupJoin(
        @Body join : JoinGroup
    ) : Call<ResponseGroupID>

    @POST("/group/mygroup/delete")
    fun groupDelete(
        @Body delete : DeleteGroup
    ) : Call<ResponseGroupID>

    @GET("/group/join/group")
    fun joinGroup(
        @Query("userID") userID: Int? = null
    ) : Call<ResponseJoinGroup>
}