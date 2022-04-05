package com.example.fflogsapi.api
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import com.example.fflogsapi.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FFLogsAPI {


    @GET("/v1/classes?api_key=" + BuildConfig.api_Key )
    fun fetchClasses():Call<String>

    @GET("/v1/zones?api_key=" + BuildConfig.api_Key)
    fun fetchZones(): Call<List<Zones>>

    @GET("/v1/rankings/encounter/{Zone}?api_key=" + BuildConfig.api_Key)
    fun fetchRankings
        (@Path("Zone") zone: String)
    : Call<List<Rankings>>

}