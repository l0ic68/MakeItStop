package com.nesta.makeitstop.addiction.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [DailyRecord::class, Addiction::class], version = 3, exportSchema = false)
abstract class AddictionDatabase : RoomDatabase() {
    abstract fun addictionDailyRecordDao(): DailyRecordDao
    abstract fun addictionDao(): AddictionDao
    companion object {
        @Volatile
        private var Instance: AddictionDatabase? = null
        fun getDatabase(context: Context): AddictionDatabase {
            return Instance ?: synchronized(this)  {
                Room.databaseBuilder(context, AddictionDatabase::class.java, "addiction_database")
                    .fallbackToDestructiveMigration(true) // ⚡ supprime l'ancienne DB et recrée la nouvelle
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
