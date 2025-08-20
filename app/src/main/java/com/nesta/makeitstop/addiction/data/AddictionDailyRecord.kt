package com.nesta.makeitstop.addiction.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "addiction_daily_record")
data class AddictionDailyRecord (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val addiction : String,
    val answers: String,
    val feelingScore: Int,
)
