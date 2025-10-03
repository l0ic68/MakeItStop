package com.nesta.makeitstop.features.feature_urgency.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WrittenReleaseViewModel : ViewModel() {
    private val _timer = MutableStateFlow(300L)
    val timer = _timer.asStateFlow()

    var countdown: Boolean = false

    fun setTimer(min: Long) {
        _timer.value = min * 60
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
            }
        }
    }

    fun stopTimer() {
        _timer.value = 0
        timerJob?.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}

@SuppressLint("DefaultLocale")
fun Long.formatTime(): String {
    val hours = this / 3600
    val minutes = (this % 3600) / 60
    val remainingSeconds = this % 60
    return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds)
}