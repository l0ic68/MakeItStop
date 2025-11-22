package com.nesta.makeitstop.features.feature_breathing.data.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionDailyRecordUiState
import com.nesta.makeitstop.features.feature_breathing.data.model.Breathing
import com.nesta.makeitstop.features.feature_breathing.data.repository.BreathingRepository
import com.nesta.makeitstop.features.feature_breathing.ui.ComponentBreathing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

data class BreathingDetails(
    val id: Int = 0,
    val name: String = "",
    val inhale: Int = 3,
    val hold: Int = 0,
    val exhale: Int = 3,
    val totalCycles: Int = 5,
)

fun BreathingDetails.toBreathing() : Breathing =
    Breathing(
        id = id,
        name = name,
        inhaleSeconds = inhale,
        holdSeconds = hold,
        exhaleSeconds = exhale,
        totalCycles = totalCycles
    )

data class BreathingUiState(
    val breathingDetails: BreathingDetails = BreathingDetails()
)

class BreathingViewModel (
    private val breathingRepository: BreathingRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(BreathingUiState())
    val uiState: StateFlow<BreathingUiState> = _uiState

    var breathingUiState by mutableStateOf(BreathingUiState())

    suspend fun saveBreathingTimer() {
        breathingRepository.insertBreathing(uiState.value.breathingDetails.toBreathing())
    }

    suspend fun saveBreathingTimerWithReturn() : ComponentBreathing {
        breathingRepository.insertBreathing(uiState.value.breathingDetails.toBreathing())
        return ComponentBreathing(
            title = uiState.value.breathingDetails.name,
            inhaleSeconds = uiState.value.breathingDetails.inhale,
            holdSeconds = uiState.value.breathingDetails.hold,
            exhaleSeconds = uiState.value.breathingDetails.exhale,
            totalCycle = uiState.value.breathingDetails.totalCycles

        )
    }

    suspend fun updateBreathingTimer() {
        breathingRepository.updateBreathing(uiState.value.breathingDetails.toBreathing())
    }

    suspend fun deleteBreathingTimer() {
        breathingRepository.deleteBreathing(uiState.value.breathingDetails.toBreathing())
    }

    val breathingsList : StateFlow<List<Breathing>> =
        breathingRepository.getAllBreathings()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(50000),
                initialValue = emptyList()
            )

    fun updateBreathingUiState(breathingDetails: BreathingDetails) {
        _uiState.update { it.copy(breathingDetails = breathingDetails) }
    }
}