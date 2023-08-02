package com.awakelab.oskar.ejercicio5m6.data.remote

import com.google.gson.annotations.SerializedName

//SerializedName setea el nombre de JSon
//{"price":450000,"id":"424905","type":"buy","img_src":"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"}
data class Terreno(
    val id: String,
    @SerializedName("price") val precio: Int,
    @SerializedName("type") val tipo: String,
    @SerializedName("img_src") val img: String,
)
