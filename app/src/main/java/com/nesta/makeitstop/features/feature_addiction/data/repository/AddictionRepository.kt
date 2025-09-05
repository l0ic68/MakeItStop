package com.nesta.makeitstop.features.feature_addiction.data.repository

import com.nesta.makeitstop.features.feature_addiction.data.model.Addiction
import kotlinx.coroutines.flow.Flow

interface AddictionRepository {

    fun getAllAddiction(): Flow<List<Addiction>>

    suspend fun insertAddiction(item: Addiction): Long

    suspend fun deleteAddiction(item: Addiction)

    suspend fun updateAddiction(item: Addiction)

}