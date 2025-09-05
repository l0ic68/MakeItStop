package com.nesta.makeitstop.features.feature_addiction.data.repository

import com.nesta.makeitstop.features.feature_addiction.data.dao.AddictionDao
import com.nesta.makeitstop.features.feature_addiction.data.model.Addiction
import kotlinx.coroutines.flow.Flow

class OfflineAddictionRepository(private val addictionDao: AddictionDao) : AddictionRepository {
    override fun getAllAddiction(): Flow<List<Addiction>> {
        return addictionDao.getAllAddictions()
    }

    override suspend fun insertAddiction(item: Addiction): Long {
        return addictionDao.insert(item)
    }

    override suspend fun deleteAddiction(item: Addiction) {
        addictionDao.delete(item)
    }

    override suspend fun updateAddiction(item: Addiction) {
        addictionDao.update(item)
    }
}