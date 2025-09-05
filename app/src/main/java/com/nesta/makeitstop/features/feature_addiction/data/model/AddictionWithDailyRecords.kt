package com.nesta.makeitstop.features.feature_addiction.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.nesta.makeitstop.features.feature_addiction.data.model.DailyRecord

data class AddictionWithDailyRecords(
    @Embedded val addiction: Addiction,
    @Relation(
        parentColumn = "id",
        entityColumn = "addictionId"
    )
    val dailyRecords: List<DailyRecord>
)