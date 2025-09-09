package com.nesta.makeitstop.features.feature_sleeping_journal.data.repository

import com.nesta.makeitstop.features.feature_sleeping_journal.data.model.SleepingJournalRecord
import kotlinx.coroutines.flow.Flow

interface SleepingJournalRecordRepository {

    suspend fun getAllJournal(): Flow<List<SleepingJournalRecord>>

    suspend fun insertJournal(item: SleepingJournalRecord) : Long

    suspend fun deleteJournal(item: SleepingJournalRecord)

    suspend fun updateJournal(item: SleepingJournalRecord)

}