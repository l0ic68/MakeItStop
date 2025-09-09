package com.nesta.makeitstop.features.feature_sleeping_journal.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nesta.makeitstop.features.feature_sleeping_journal.data.model.SleepingJournalRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepingJournalRecordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: SleepingJournalRecord) : Long

    @Update
    suspend fun update(item: SleepingJournalRecord)

    @Delete
    suspend fun delete(item: SleepingJournalRecord)

    @Query("SELECT * FROM sleeping_journaling where id = :id")
    fun getJournal(id: Int): Flow<SleepingJournalRecord>


    @Query("SELECT * FROM sleeping_journaling order BY date")
    fun getAllJournals(): Flow<List<SleepingJournalRecord>>
}