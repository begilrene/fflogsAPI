package com.example.fflogsapi.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "FFlogsFetcher"
class FFLogsFetcher {
    private val ffLogsApi: FFLogsAPI
    init{
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://fflogs.com:443")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        ffLogsApi = retrofit.create(FFLogsAPI::class.java)
    }


    fun fetchZones(){
        Log.e(TAG, "Fetch zones called.")
        //val responseLiveData:MutableLiveData<List<String>> = MutableLiveData()
       // val ffLogsRequest: Call<List<Zones>> = ffLogsApi.fetchZones()


    }
}