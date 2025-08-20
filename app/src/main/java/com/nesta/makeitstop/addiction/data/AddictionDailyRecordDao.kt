package com.nesta.makeitstop.addiction.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AddictionDailyRecordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: AddictionDailyRecord)

    @Update
    suspend fun update(item: AddictionDailyRecord)

    @Delete
    suspend fun delete(item: AddictionDailyRecord)

    @Query("SELECT * from addiction_daily_record where id = :id")
    fun getAddictionDailyRecord(id:Int): Flow<AddictionDailyRecord>

    @Query("SELECT * FROM addiction_daily_record ORDER BY addiction ASC")
    fun getAllDailyRecords(): Flow<List<AddictionDailyRecord>>
}