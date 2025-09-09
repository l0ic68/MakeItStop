package com.nesta.makeitstop.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.nesta.makeitstop.MakeItStopApplication
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionDailyRecordEntryViewModel
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionViewModel
import com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel.SleepingJournalRecordViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
           // val application = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MakeItStopApplication
            AddictionDailyRecordEntryViewModel(
                makeItStopApplication().container.dailyRecordRepository,
            )
        }
        initializer {
            AddictionViewModel(
                makeItStopApplication().container.addictionRepository
            )
        }
        initializer {
            SleepingJournalRecordViewModel(
                makeItStopApplication().container.sleepingJournalRecordRepository
            )
        }
    }
}

fun CreationExtras.makeItStopApplication(): MakeItStopApplication = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MakeItStopApplication)