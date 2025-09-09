package com.nesta.makeitstop.features.feature_sleeping_journal.data.repository

import com.nesta.makeitstop.features.feature_sleeping_journal.data.dao.SleepingJournalRecordDao
import com.nesta.makeitstop.features.feature_sleeping_journal.data.model.SleepingJournalRecord
import kotlinx.coroutines.flow.Flow

class OfflineSleepingJournalRecordRepository(
    private val sleepingJournalRecordDao: SleepingJournalRecordDao
) : SleepingJournalRecordRepository {

    override suspend fun getAllJournal(): Flow<List<SleepingJournalRecord>> {
        return sleepingJournalRecordDao.getAllJournals()
    }

    override suspend fun insertJournal(item: SleepingJournalRecord): Long {
        return sleepingJournalRecordDao.insert(item)
    }

    override suspend fun deleteJournal(item: SleepingJournalRecord) {
        sleepingJournalRecordDao.delete(item)
    }

    override suspend fun updateJournal(item: SleepingJournalRecord) {
        sleepingJournalRecordDao.update(item)
    }
}