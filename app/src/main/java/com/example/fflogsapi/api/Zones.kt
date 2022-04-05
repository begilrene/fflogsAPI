package com.example.fflogsapi.api

import com.google.gson.annotations.SerializedName

class Zones{
    @SerializedName("id") private var id: Int = 0
    @SerializedName("name") private var name: String = ""
    @SerializedName("frozen") private var frozen: Boolean = true
    @SerializedName("encounters") private var encounters =  ArrayList<Dungeons>()
    //@SerializedName("brackets") private var brackets = ArrayList<Brackets>()

    override fun toString(): String {
        return "Zones(id=$id, name='$name', frozen=$frozen, encounters=$encounters,)"// brackets=$brackets)"
    }


}

class Dungeons{
    @SerializedName("id") private var id: Int = 0
    @SerializedName("name") private var name: String = ""
    @SerializedName("npcID") private var npcID: Int = 0
}

class Brackets{
    @SerializedName("id") private var id: Int = 0
    @SerializedName("name") private var name: String = ""
}