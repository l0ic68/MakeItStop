package com.nesta.makeitstop.addiction.data

import kotlinx.coroutines.flow.Flow

class OfflineAddictionRepository(private val addictionDao: AddictionDao) : AddictionRepository {
    override fun getAllAddiction(): Flow<List<Addiction>> {
        return addictionDao.getAllAddictions()
    }

    override suspend fun insertAddiction(item: Addiction) {
        addictionDao.insert(item)
    }

    override suspend fun deleteAddiction(item: Addiction) {
        addictionDao.delete(item)
    }

    override suspend fun updateAddiction(item: Addiction) {
        addictionDao.update(item)
    }
}