package com.nesta.makeitstop.addiction.data

import kotlinx.coroutines.flow.Flow

class OfflineAddictionDailyRecordsRepository(
    private val addictionDailyRecordDao: AddictionDailyRecordDao
) : AddictionDailyRecordRepository
{
    override fun getAllAddictionDailyRecord(): Flow<List<AddictionDailyRecord>> {
       return addictionDailyRecordDao.getAllDailyRecords()
    }

    override fun getAddictionDailyRecord(id: Int): Flow<AddictionDailyRecord?> {
        return addictionDailyRecordDao.getAddictionDailyRecord(id)
    }

    override suspend fun insertAddictionDailyRecord(item: AddictionDailyRecord) {
        addictionDailyRecordDao.insert(item)
    }

    override suspend fun deleteAddictionDailyRecord(item: AddictionDailyRecord) {
       addictionDailyRecordDao.delete(item)
    }

    override suspend fun updateAddictionDailyRecord(item: AddictionDailyRecord) {
       addictionDailyRecordDao.update(item)
    }
}