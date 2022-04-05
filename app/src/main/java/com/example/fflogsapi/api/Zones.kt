package com.example.fflogsapi.api

import com.google.gson.annotations.SerializedName

class Zones{
    @SerializedName("id") private var id: Int = 0
    @SerializedName("name") private var name: String = ""
    @SerializedName("frozen") private var frozen: Boolean = true
    @SerializedName("encounters") private var encounters =  ArrayList<Dungeons>()
    //@SerializedName("brackets") private var brackets =  ArrayList<Brackets>()

    override fun toString(): String {
        var str =  "Zones(id=$id, name='$name', frozen=$frozen)"//, brackets=$brackets)"
        for (zone in encounters){
            str += zone.getID()
            str += zone.getName()
        }
        return str
    }


}

class Dungeons{
    @SerializedName("id") private var id: Int = 0
    @SerializedName("name") private var name: String = ""
    @SerializedName("npcID") private var npcID: Int = 0

    fun getID(): Int{
        return id
    }

    fun getName(): String{
        return name
    }

    fun getNID(): Int{
        return npcID
    }
}

class Brackets{
    private var id: Int = 0
    private var name: String = ""
}