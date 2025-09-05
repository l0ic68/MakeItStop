package com.nesta.makeitstop.core.database

import android.content.Context
import com.nesta.makeitstop.features.feature_addiction.data.repository.AddictionRepository
import com.nesta.makeitstop.features.feature_addiction.data.repository.DailyRecordRepository
import com.nesta.makeitstop.features.feature_addiction.data.repository.OfflineAddictionRepository
import com.nesta.makeitstop.features.feature_addiction.data.repository.OfflineDailyRecordsRepository

interface AppContainer {
    val dailyRecordRepository : DailyRecordRepository
    val addictionRepository : AddictionRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val dailyRecordRepository: DailyRecordRepository by lazy {
        OfflineDailyRecordsRepository(
            AddictionDatabase.getDatabase(context).addictionDailyRecordDao()
        )
    }
    override val addictionRepository: AddictionRepository by lazy {
        OfflineAddictionRepository(AddictionDatabase.getDatabase(context).addictionDao())
    }

}