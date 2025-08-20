package com.nesta.makeitstop.addiction.data

import android.content.Context

interface AppContainer {
    val addictionDailyRecordRepository : AddictionDailyRecordRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val addictionDailyRecordRepository: AddictionDailyRecordRepository by lazy {
        OfflineAddictionDailyRecordsRepository(AddictionDatabase.getDatabase(context).addictionDailyRecordDao())
    }
}