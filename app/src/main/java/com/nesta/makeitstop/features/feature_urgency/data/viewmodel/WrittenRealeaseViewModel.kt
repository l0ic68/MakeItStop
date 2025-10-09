package com.nesta.makeitstop.features.feature_urgency.data.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel.SleepingJournal
import com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel.SleepingJournalUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


data class WrittenReleaseUiState(
    val timer: Long = 0L,
    val text: String = "",
    val isTextEnabled:Boolean = false,
)

class WrittenReleaseViewModel : ViewModel() {
    private val _timer = MutableStateFlow(300L)
    val timer = _timer.asStateFlow()

    private val _uiState = MutableStateFlow(WrittenReleaseUiState())
    var uiState: StateFlow<WrittenReleaseUiState> = _uiState

    var countdown: Boolean = false

    fun setTimer(min: Long) {
        _timer.value = min * 60
        _uiState.value = _uiState.value.copy(timer = _timer.value)
    }

    fun setIsCountDown(isCountDown: Boolean) {
        countdown = isCountDown
    }

    private var timerJob: Job? = null

    fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000)
                if (countdown) {
                    _timer.value--
                }
                else {
                    _timer.value++
                }

                _uiState.value = _uiState.value.copy(timer = _timer.value)
                _uiState.value = _uiState.value.copy(isTextEnabled = true)

                if ( _timer.value == 0L) {
                    stopTimer()
                }

            }
        }
    }

    fun stopTimer() {
        _timer.value = 0
        timerJob?.cancel()
        _uiState.value = _uiState.value.copy(timer = 0)
        _uiState.value = _uiState.value.copy(isTextEnabled = false)

    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }

    fun updateWrittenReleaseText(text: String) {
        _uiState.value = _uiState.value.copy(text = text)
    }
}

@SuppressLint("DefaultLocale")
fun Long.formatTime(): String {
    val hours = this / 3600
    val minutes = (this % 3600) / 60
    val remainingSeconds = this % 60
    return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds)
}