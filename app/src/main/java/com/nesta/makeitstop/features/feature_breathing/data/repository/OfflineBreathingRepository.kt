package com.nesta.makeitstop.features.feature_breathing.data.repository

import com.nesta.makeitstop.features.feature_breathing.data.dao.BreathingDao
import com.nesta.makeitstop.features.feature_breathing.data.model.Breathing
import kotlinx.coroutines.flow.Flow

class OfflineBreathingRepository(private val breathingDao: BreathingDao) : BreathingRepository {
    override fun getAllBreathings(): Flow<List<Breathing>> {
        return breathingDao.getAllBreathings()
    }

    override suspend fun insertBreathing(item: Breathing): Long {
        return breathingDao.insert(item)
    }

    override suspend fun updateBreathing(item: Breathing) {
        breathingDao.update(item)
    }

    override suspend fun deleteBreathing(item: Breathing) {
        breathingDao.delete(item)
    }
}