package com.nesta.makeitstop.core.database

import android.content.Context
import com.nesta.makeitstop.features.feature_addiction.data.repository.AddictionRepository
import com.nesta.makeitstop.features.feature_addiction.data.repository.DailyRecordRepository
import com.nesta.makeitstop.features.feature_addiction.data.repository.OfflineAddictionRepository
import com.nesta.makeitstop.features.feature_addiction.data.repository.OfflineDailyRecordsRepository
import com.nesta.makeitstop.features.feature_sleeping_journal.data.repository.OfflineSleepingJournalRecordRepository
import com.nesta.makeitstop.features.feature_sleeping_journal.data.repository.SleepingJournalRecordRepository

interface AppContainer {
    val dailyRecordRepository : DailyRecordRepository
    val addictionRepository : AddictionRepository
    val sleepingJournalRecordRepository : SleepingJournalRecordRepository

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

    override val sleepingJournalRecordRepository: SleepingJournalRecordRepository by lazy {
        OfflineSleepingJournalRecordRepository(AddictionDatabase.getDatabase(context).sleepingJournalRecordDao())
    }

}