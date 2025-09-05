package com.nesta.makeitstop.features.feature_addiction.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nesta.makeitstop.features.feature_addiction.data.model.Addiction
import kotlinx.coroutines.flow.Flow

@Dao
interface AddictionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Addiction): Long

    @Update
    suspend fun update(item: Addiction)

    @Delete
    suspend fun delete(item: Addiction)

    @Query("SELECT * from ADDICTION where id = :id")
    fun getAddiction(id:Int): Flow<Addiction>

    @Query("SELECT * from ADDICTION")
    fun getAllAddictions(): Flow<List<Addiction>>

}