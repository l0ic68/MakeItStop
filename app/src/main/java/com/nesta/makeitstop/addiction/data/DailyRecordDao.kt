package com.nesta.makeitstop.addiction.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyRecordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: DailyRecord)

    @Update
    suspend fun update(item: DailyRecord)

    @Delete
    suspend fun delete(item: DailyRecord)

    @Query("SELECT * from addiction_daily_record where id = :id")
    fun getAddictionDailyRecord(id:Int): Flow<DailyRecord>

    @Query("SELECT * FROM addiction_daily_record ORDER BY addiction ASC")
    fun getAllDailyRecords(): Flow<List<DailyRecord>>
}