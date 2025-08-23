package com.nesta.makeitstop.addiction.data

import kotlinx.coroutines.flow.Flow

interface AddictionRepository {

    fun getAllAddiction(): Flow<List<Addiction>>



    suspend fun insertAddiction(item: Addiction)

    suspend fun deleteAddiction(item: Addiction)

    suspend fun updateAddiction(item: Addiction)

}