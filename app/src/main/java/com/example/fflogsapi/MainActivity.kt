package com.example.fflogsapi

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.fflogsapi.api.FFLogsAPI
import com.example.fflogsapi.api.Rankings
import com.example.fflogsapi.api.Zones
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private var zoneView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<View>(R.id.get_zone_id_button)
            .setOnClickListener{ getZoneData() }
        findViewById<View>(R.id.get_ranking_zone_button)
            .setOnClickListener{ getRankingData(4500)}
    }

    fun getRankingData(zone: Int){

        zoneView?.setText("")
        zoneView = findViewById(R.id.zone_text)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fflogs.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val fflogsApi = retrofit.create(FFLogsAPI::class.java)
        val call = fflogsApi.fetchRankings(zone.toString())
        var content = ""
        call.enqueue(object: Callback<List<Rankings>>{
            override fun onResponse(
                call: Call<List<Rankings>>,
                response: Response<List<Rankings>>
            ) {
                if(!response.isSuccessful){
                    zoneView?.setText("Code: " + response.code() +"\n" +  zone.toString() )
                    return
                }

                val rankResponse = response.body()
                for (rank in rankResponse!!){
                    content += "${rank}"
                    zoneView?.append(content)
                }
                Log.d(TAG, "Response recieved $rankResponse from $response")
            }

            override fun onFailure(call: Call<List<Rankings>>, t: Throwable) {
                Log.d(TAG, "RANKING FAILURE!!!")
                zoneView?.setText(t.message + call.toString())
            }

        })
    }

    fun getZoneData(): String{
        zoneView?.setText("")
        zoneView = findViewById(R.id.zone_text)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fflogs.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val fflogsApi = retrofit.create(FFLogsAPI::class.java)
        val call = fflogsApi.fetchZones()
        var content = ""
        call.enqueue(object: Callback<List<Zones>>{
            override fun onResponse(call: Call<List<Zones>>, response: Response<List<Zones>>) {
                if(!response.isSuccessful) {
                    zoneView?.setText("Code:" + response.code())
                    return
                }

                val zoneResponse = response.body()
                for(zone in zoneResponse!!){

                    content += "${zone}"
                    zoneView?.append(content)

                }
                Log.d(TAG, "Response recieved $zoneResponse from $response")


            }
            override fun onFailure(call: Call<List<Zones>>, t: Throwable) {
                Log.d(TAG, "FAILURE!!!")
                zoneView?.setText(t.message)
            }
        })

        return content
    }

}