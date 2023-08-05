package com.awakelab.oskar.ejercicio5m6.data

import androidx.lifecycle.LiveData
import com.awakelab.oskar.ejercicio5m6.data.local.TerrenoDao
import com.awakelab.oskar.ejercicio5m6.data.local.TerrenoEntity
import com.awakelab.oskar.ejercicio5m6.data.remote.Terreno
import com.awakelab.oskar.ejercicio5m6.data.remote.TerrenoApi
import retrofit2.Response

class Repositorio(
    private val terrenoApi: TerrenoApi,
    private val terrenoDao: TerrenoDao,
) {

    fun obtenerTerreno(id:String): LiveData<TerrenoEntity> = terrenoDao.getTerreno(id)
    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.getAllTerrenos()


    //
    suspend fun cargarTerreno() {
        val respuesta = terrenoApi.getData()

        if (respuesta.isSuccessful) {
            val res = respuesta.body()
            res?.let {terrenos ->
                val terrenoEntity = terrenos.map { it.trasnformarAEntity() }
                terrenoDao.insertTerrenos(terrenoEntity)
            }
        }
    }
}

fun Terreno.trasnformarAEntity(): TerrenoEntity =
    TerrenoEntity(this.id, this.precio, this.tipo, this.img)