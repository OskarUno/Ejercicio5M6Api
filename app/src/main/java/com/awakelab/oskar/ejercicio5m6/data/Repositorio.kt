package com.awakelab.oskar.ejercicio5m6.data

import com.awakelab.oskar.ejercicio5m6.data.remote.Terreno
import com.awakelab.oskar.ejercicio5m6.data.remote.TerrenoApi

class Repositorio(private val terrenoApi: TerrenoApi) {


    suspend fun cargarTerreno(): List<Terreno> {
        val respuesta = terrenoApi.getData()
        if (respuesta.isSuccessful) {
            val res = respuesta.body()
            res?.let {
                return it
            }
        }
        return emptyList()
    }

}