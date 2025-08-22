package com.nesta.makeitstop.addiction.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "addiction_daily_record")
data class DailyRecord (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val addiction : String,
    val firstAnswer: String,
    val secondAnswer: String,
    val thirdAnswer: String,
    val fourthAnswer: String,
    val fifthAnswer: String,
    val feelingScore: Float,
)
