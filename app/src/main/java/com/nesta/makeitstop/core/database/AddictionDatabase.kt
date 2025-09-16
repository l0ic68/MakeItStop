package com.nesta.makeitstop.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nesta.makeitstop.features.feature_addiction.data.model.Addiction
import com.nesta.makeitstop.features.feature_addiction.data.dao.AddictionDao
import com.nesta.makeitstop.features.feature_addiction.data.model.DailyRecord
import com.nesta.makeitstop.features.feature_addiction.data.dao.DailyRecordDao
import com.nesta.makeitstop.features.feature_sleeping_journal.data.dao.SleepingJournalRecordDao
import com.nesta.makeitstop.features.feature_sleeping_journal.data.model.SleepingJournalRecord
import com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel.SleepingJournal

@Database(entities = [
    DailyRecord::class,
    Addiction::class,
    SleepingJournalRecord::class], version = 1, exportSchema = true)
abstract class AddictionDatabase : RoomDatabase() {
    abstract fun addictionDailyRecordDao(): DailyRecordDao
    abstract fun addictionDao(): AddictionDao

    abstract fun sleepingJournalRecordDao(): SleepingJournalRecordDao
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