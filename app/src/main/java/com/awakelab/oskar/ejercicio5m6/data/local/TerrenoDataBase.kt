package com.awakelab.oskar.ejercicio5m6.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TerrenoEntity::class], version = 1)
abstract class TerrenoDataBase : RoomDatabase() {

    abstract fun getTerrenoDao(): TerrenoDao

    companion object {
        @Volatile
        private var INSTANCE: TerrenoDataBase? = null

        fun getDatabase(context: Context): TerrenoDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, TerrenoDataBase::class.java, "tabla_terreno"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}