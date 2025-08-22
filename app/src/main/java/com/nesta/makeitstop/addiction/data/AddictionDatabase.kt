package com.nesta.makeitstop.addiction.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [DailyRecord::class], version = 1, exportSchema = false)
abstract class AddictionDatabase : RoomDatabase() {
    abstract fun addictionDailyRecordDao(): DailyRecordDao
    companion object {
        @Volatile
        private var Instance: AddictionDatabase? = null
        fun getDatabase(context: Context): AddictionDatabase {
            return Instance ?: synchronized(this)  {
                Room.databaseBuilder(context, AddictionDatabase::class.java, "addiction_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
