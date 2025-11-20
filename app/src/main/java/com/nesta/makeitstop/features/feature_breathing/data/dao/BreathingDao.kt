package com.nesta.makeitstop.features.feature_breathing.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Update
import com.nesta.makeitstop.features.feature_breathing.data.model.Breathing
import kotlinx.coroutines.flow.Flow

@Dao
interface BreathingDao {
    @Insert(onConflict = IGNORE)
    suspend fun insert(item: Breathing) : Long

    @Update
    suspend fun update(item: Breathing)

    @Delete
    suspend fun delete(item : Breathing)

    @Query("SELECT * FROM BreathingTimer")
    fun getAllBreathings(): Flow<List<Breathing>>
}