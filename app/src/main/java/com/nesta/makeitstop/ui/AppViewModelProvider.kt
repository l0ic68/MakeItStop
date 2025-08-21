package com.nesta.makeitstop.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.nesta.makeitstop.MakeItStopApplication
import com.nesta.makeitstop.ui.addiction.AddictionDailyRecordEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            AddictionDailyRecordEntryViewModel(MakeItStopApplication().container.addictionDailyRecordRepository)
        }
    }
}