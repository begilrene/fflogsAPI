package com.example.fflogsapi.api
import com.google.gson.annotations.SerializedName

class Rankings {
    @SerializedName("total") private var total: Int = 0
    @SerializedName("rankings") private var rankings =  ArrayList<EncounterRankings>()
}

class EncounterRankings {
    @SerializedName("name") private var name: String = ""
    @SerializedName("class") private var game_class: Long = 0
    @SerializedName("total") private var dps: Double = 0.0

    fun getName(): String{
        return name
    }

    fun getClass(): Long{
        return game_class
    }

    fun getDPS(): Double{
        return dps
    }

}
