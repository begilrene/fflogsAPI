package com.example.fflogsapi.api
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url
private const val api_key = "bf91115bb9c6399d848ba5adfa153582"
interface FFLogsAPI {

    @GET("/v1/classes?api_key=$api_key")
    fun fetchClasses():Call<String>

    @GET("/v1/zones?api_key=$api_key")
    fun fetchZones():Call<List<Zones>>

}