package com.example.fflogsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.fflogsapi.api.FFLogsAPI
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

        zoneView = findViewById(R.id.textView)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fflogs.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val fflogsApi = retrofit.create(FFLogsAPI::class.java)
        val call = fflogsApi.fetchZones()
        call.enqueue(object: Callback<List<Zones>>{
            override fun onResponse(call: Call<List<Zones>>, response: Response<List<Zones>>) {
                if(!response.isSuccessful) {
                    zoneView?.setText("Code:" + response.code())
                    return
                }

                val zoneResponse = response.body()
                for(zone in zoneResponse!!){
                    var content = ""
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
        //findViewById<View>(R.id.button).setOnClickListener{ getData() }
    }


}