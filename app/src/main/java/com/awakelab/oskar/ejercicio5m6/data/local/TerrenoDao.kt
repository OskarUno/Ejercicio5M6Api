package com.awakelab.oskar.ejercicio5m6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.awakelab.oskar.ejercicio5m6.data.remote.Terreno

@Dao
interface TerrenoDao {
    @Insert
    suspend fun insertTerreno(terrenoEntity: TerrenoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerrenos(terrenoEntity: List<TerrenoEntity>)

    @Query("select * from tabla_terreno order by id ASC")
    fun getAllTerrenos(): LiveData<List<TerrenoEntity>>
}