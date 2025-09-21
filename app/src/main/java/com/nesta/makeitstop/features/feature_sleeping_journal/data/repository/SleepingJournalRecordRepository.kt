package com.nesta.makeitstop.features.feature_sleeping_journal.data.repository

import com.nesta.makeitstop.features.feature_sleeping_journal.data.model.SleepingJournalRecord
import kotlinx.coroutines.flow.Flow

interface SleepingJournalRecordRepository {

    fun getAllJournal(): Flow<List<SleepingJournalRecord>>
    fun getJournal(item : Int): Flow<SleepingJournalRecord>

    suspend fun isJournalAlreadyCreate(item : Long):Boolean
    fun getJournal(item : Long): Flow<SleepingJournalRecord>

    suspend fun insertJournal(item: SleepingJournalRecord) : Long

    suspend fun deleteJournal(item: SleepingJournalRecord)
    suspend fun deleteJournal(item: Int)

    suspend fun updateJournal(item: SleepingJournalRecord)

}