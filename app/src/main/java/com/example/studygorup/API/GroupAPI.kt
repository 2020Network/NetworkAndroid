package com.example.studygorup.API

import com.example.studygorup.DTO.Group
import com.example.studygorup.DTO.Responsegroup
import com.example.studygorup.DTO.Responsesign
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface GroupAPI {
    @POST("/group/create")
    fun create(
        @Body group : Group
    ) : Call<Responsesign>

    @GET("/group")
    fun allgroup( ) : Call<Responsegroup>

    @GET("/group/mygroup")
    fun mygroup(
        @Query("userID") userID : Int? = null
    ) : Call<List<Responsegroup>>
}