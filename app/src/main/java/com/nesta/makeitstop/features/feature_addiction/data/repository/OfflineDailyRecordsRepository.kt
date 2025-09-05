package com.nesta.makeitstop.features.feature_addiction.data.repository

import com.nesta.makeitstop.features.feature_addiction.data.dao.DailyRecordDao
import com.nesta.makeitstop.features.feature_addiction.data.model.DailyRecord
import kotlinx.coroutines.flow.Flow

class OfflineDailyRecordsRepository(
    private val dailyRecordDao: DailyRecordDao
) : DailyRecordRepository
{
    override fun getAllAddictionDailyRecord(): Flow<List<DailyRecord>> {
       return dailyRecordDao.getAllDailyRecords()
    }


    override fun getRecordsForAddiction(id: Int): Flow<List<DailyRecord?>> {
        return dailyRecordDao.getRecordsForAddiction(id)
    }

    override fun getAddictionDailyRecord(id: Int): Flow<DailyRecord?> {
        return dailyRecordDao.getAddictionDailyRecord(id)
    }


    override suspend fun insertAddictionDailyRecord(item: DailyRecord) {
        dailyRecordDao.insert(item)
    }

    override suspend fun deleteAddictionDailyRecord(item: DailyRecord) {
       dailyRecordDao.delete(item)
    }

    override suspend fun updateAddictionDailyRecord(item: DailyRecord) {
       dailyRecordDao.update(item)
    }
}