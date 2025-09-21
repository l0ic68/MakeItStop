package com.nesta.makeitstop.features.feature_sleeping_journal.data.repository

import com.nesta.makeitstop.features.feature_sleeping_journal.data.dao.SleepingJournalRecordDao
import com.nesta.makeitstop.features.feature_sleeping_journal.data.model.SleepingJournalRecord
import kotlinx.coroutines.flow.Flow

class OfflineSleepingJournalRecordRepository(
    private val sleepingJournalRecordDao: SleepingJournalRecordDao
) : SleepingJournalRecordRepository {

    override fun getAllJournal(): Flow<List<SleepingJournalRecord>> {
        return sleepingJournalRecordDao.getAllJournals()
    }

    override fun getJournal(item : Int): Flow<SleepingJournalRecord> {
        return sleepingJournalRecordDao.getJournal(item)
    }
    override fun getJournal(item : Long): Flow<SleepingJournalRecord> {
        return sleepingJournalRecordDao.getJournal(item)
    }

    override suspend fun isJournalAlreadyCreate(item : Long): Boolean {
        return sleepingJournalRecordDao.isJournalAlreadyCreate(item)
    }

    override suspend fun insertJournal(item: SleepingJournalRecord): Long {
        return sleepingJournalRecordDao.insert(item)
    }

    override suspend fun deleteJournal(item: SleepingJournalRecord) {
        sleepingJournalRecordDao.delete(item)
    }

    override suspend fun deleteJournal(item: Int) {
        sleepingJournalRecordDao.deleteById(item)
    }

    override suspend fun updateJournal(item: SleepingJournalRecord) {
        sleepingJournalRecordDao.update(item)
    }
}