package com.nesta.makeitstop.addiction.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "addiction_daily_record",
    foreignKeys = [
        ForeignKey(
            entity = Addiction::class,
            parentColumns = ["id"],
            childColumns = ["addictionId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["addictionId"])]
)
data class DailyRecord (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val addictionId : Int, // foreign key -> Addiction
    val firstAnswer: String,
    val secondAnswer: String,
    val thirdAnswer: String,
    val fourthAnswer: String,
    val fifthAnswer: String,
    val feelingScore: Float,
)
