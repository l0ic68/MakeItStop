package com.nesta.makeitstop.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nesta.makeitstop.features.feature_addiction.data.model.Addiction
import com.nesta.makeitstop.features.feature_addiction.data.dao.AddictionDao
import com.nesta.makeitstop.features.feature_addiction.data.model.DailyRecord
import com.nesta.makeitstop.features.feature_addiction.data.dao.DailyRecordDao
import com.nesta.makeitstop.features.feature_breathing.data.dao.BreathingDao
import com.nesta.makeitstop.features.feature_breathing.data.model.Breathing
import com.nesta.makeitstop.features.feature_sleeping_journal.data.dao.SleepingJournalRecordDao
import com.nesta.makeitstop.features.feature_sleeping_journal.data.model.SleepingJournalRecord

@Database(
    entities = [
        DailyRecord::class,
        Addiction::class,
        SleepingJournalRecord::class,
        Breathing::class
    ], version = 2, exportSchema = true
)
abstract class AddictionDatabase : RoomDatabase() {
    abstract fun addictionDailyRecordDao(): DailyRecordDao
    abstract fun addictionDao(): AddictionDao

    abstract fun sleepingJournalRecordDao(): SleepingJournalRecordDao
    abstract fun breathingDao(): BreathingDao

    companion object {
        @Volatile
        private var Instance: AddictionDatabase? = null
        fun getDatabase(context: Context): AddictionDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AddictionDatabase::class.java, "addiction_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}