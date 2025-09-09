package com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionDailyRecordUiState
import com.nesta.makeitstop.features.feature_sleeping_journal.data.model.SleepingJournalRecord
import com.nesta.makeitstop.features.feature_sleeping_journal.data.repository.SleepingJournalRecordRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.time.LocalDate.now

data class SleepingJournalUiState(
    val journal: SleepingJournal = SleepingJournal(),
    val isEntryValid: Boolean = false
)

data class SleepingJournal (
    val id: Int = 0,
    val date: LocalDate = now(),
    val firstQuestion: String = "",
    val secondQuestion: String = "",
    val thirdQuestion: String = "",
)

fun SleepingJournal.toSleepingJournalRecord(): SleepingJournalRecord =
    SleepingJournalRecord(
        id = id,
        date = date.toString(),
        firstQuestion = firstQuestion,
        secondQuestion = secondQuestion,
        thirdQuestion = thirdQuestion
    )

class SleepingJournalRecordViewModel (
    private val sleepingJournalRecordRepository: SleepingJournalRecordRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SleepingJournalUiState())
    val uiState: StateFlow<SleepingJournalUiState> = _uiState

    var sleepingJournalUiState by mutableStateOf(SleepingJournalUiState())

    suspend fun saveSleepingJournal() {
        if (validateFirstEntry()) {
            sleepingJournalRecordRepository.insertJournal(sleepingJournalUiState.journal.toSleepingJournalRecord())
        }
    }

    private fun validateFirstEntry(uiState: SleepingJournal = sleepingJournalUiState.journal) : Boolean {
        return with(uiState) {
            !firstQuestion.isEmpty() &&
                    !secondQuestion.isEmpty() &&
                    !thirdQuestion.isEmpty()
        }
    }

    fun updateSleepingRecordUiState(sleepingJournal: SleepingJournal) {
        sleepingJournalUiState =
            SleepingJournalUiState(
                journal = sleepingJournal,
                isEntryValid = validateFirstEntry(sleepingJournal)
            )
    }

}