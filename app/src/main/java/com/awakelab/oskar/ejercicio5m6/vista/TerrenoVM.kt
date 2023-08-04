package com.awakelab.oskar.ejercicio5m6.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.awakelab.oskar.ejercicio5m6.data.Repositorio
import com.awakelab.oskar.ejercicio5m6.data.local.TerrenoDataBase
import com.awakelab.oskar.ejercicio5m6.data.remote.Terreno
import com.awakelab.oskar.ejercicio5m6.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(aplication: Application) : AndroidViewModel(aplication) {
    private val repositorio: Repositorio

    //val terrenosLiveData = MutableLiveData<List<Terreno>>()
    fun terrenosLiveData() = repositorio.obtenerTerrenos()

    init {
        val api = TerrenoRetroFit.getRetrofitTerreno()
        val terrenoBaseDatos = TerrenoDataBase.getDatabase(aplication).getTerrenoDao()
        repositorio = Repositorio(api, terrenoBaseDatos)
    }

    fun getAllTerrenos() = viewModelScope.launch {
      //  terrenosLiveData.value = repositorio.cargarTerreno()
        repositorio.cargarTerreno()
    }
}