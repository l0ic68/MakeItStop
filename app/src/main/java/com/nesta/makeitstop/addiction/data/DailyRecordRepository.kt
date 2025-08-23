package com.nesta.makeitstop.addiction.data

import kotlinx.coroutines.flow.Flow

interface DailyRecordRepository {
    fun getAllAddictionDailyRecord(): Flow<List<DailyRecord>>

    fun getAddictionDailyRecord(id: Int): Flow<DailyRecord?>

    fun getRecordsForAddiction(id: Int): Flow<List<DailyRecord?>>

    suspend fun insertAddictionDailyRecord(item: DailyRecord)

    suspend fun deleteAddictionDailyRecord(item: DailyRecord)

    suspend fun updateAddictionDailyRecord(item: DailyRecord)
}