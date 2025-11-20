package com.nesta.makeitstop.features.feature_breathing.data.repository

import com.nesta.makeitstop.features.feature_breathing.data.model.Breathing
import kotlinx.coroutines.flow.Flow

interface BreathingRepository {

    fun getAllBreathings(): Flow<List<Breathing>>

    suspend fun insertBreathing(item: Breathing) : Long

    suspend fun updateBreathing(item: Breathing)

    suspend fun deleteBreathing(item: Breathing)
}