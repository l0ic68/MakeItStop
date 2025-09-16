package com.nesta.makeitstop.features.feature_sleeping_journal.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "sleeping_journaling")
data class SleepingJournalRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String,
    val firstQuestion: String,
    val secondQuestion: String,
    val thirdQuestion: String,
    val epoch: Long,
)

