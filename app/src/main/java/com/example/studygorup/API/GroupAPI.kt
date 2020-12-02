package com.example.studygorup.API

import com.example.studygorup.DTO.Group
import com.example.studygorup.DTO.Responsesign
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface GroupAPI {
    @POST("/group/create")
    fun create(
        @Body group : Group
    ) : Call<Responsesign>
}