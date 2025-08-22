package com.nesta.makeitstop.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.nesta.makeitstop.MakeItStopApplication
import com.nesta.makeitstop.ui.addiction.AddictionDailyRecordEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
           // val application = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MakeItStopApplication
            AddictionDailyRecordEntryViewModel(makeItStopApplication().container.dailyRecordRepository)
        }
    }
}

fun CreationExtras.makeItStopApplication(): MakeItStopApplication = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MakeItStopApplication)