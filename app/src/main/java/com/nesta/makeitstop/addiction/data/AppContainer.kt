package com.nesta.makeitstop.addiction.data

import android.content.Context

interface AppContainer {
    val dailyRecordRepository : DailyRecordRepository
    val addictionRepository : AddictionRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val dailyRecordRepository: DailyRecordRepository by lazy {
        OfflineDailyRecordsRepository(AddictionDatabase.getDatabase(context).addictionDailyRecordDao())
    }
    override val addictionRepository: AddictionRepository by lazy {
        OfflineAddictionRepository(AddictionDatabase.getDatabase(context).addictionDao())
    }

}