package com.nesta.makeitstop.addiction.data

import kotlinx.coroutines.flow.Flow

interface AddictionDailyRecordRepository {
    fun getAllAddictionDailyRecord(): Flow<List<AddictionDailyRecord>>

    fun getAddictionDailyRecord(id: Int): Flow<AddictionDailyRecord?>

    suspend fun insertAddictionDailyRecord(item: AddictionDailyRecord)

    suspend fun deleteAddictionDailyRecord(item: AddictionDailyRecord)

    suspend fun updateAddictionDailyRecord(item: AddictionDailyRecord)
}