package com.responsi.h1d023079.footballclub.data.remote

import com.responsi.h1d023079.footballclub.data.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballApi {
    @GET("teams/{id}")
    suspend fun getTeamDetails(
        @Path("id") teamId: Int,
        @Header("X-Auth-Token") apiToken: String = Constants.API_TOKEN
    ): Response<TeamResponse>
}
