package com.nesta.makeitstop.features.feature_addiction.data.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nesta.makeitstop.features.feature_addiction.data.model.Addiction
import com.nesta.makeitstop.features.feature_addiction.data.repository.AddictionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

data class AddictionUiState(
    val addictionDetails: AddictionDetails = AddictionDetails(),
    val showDialog: Boolean = false,
    val addictionName: String = ""
)

data class AddictionDetails(
    val id: Int = 0,
    val addiction: String = "",
)

class AddictionViewModel(
    private val addictionRepository: AddictionRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddictionUiState())
    val uiState: StateFlow<AddictionUiState> = _uiState

    val addictionList: StateFlow<List<Addiction>> =
        addictionRepository.getAllAddiction()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(50000),
                initialValue = emptyList()
            )

    suspend fun saveAddiction(): Int {
        val newId: Long = addictionRepository.insertAddiction(_uiState.value.addictionDetails.toAddiction())
        return newId.toInt()
    }

    fun addAddictionClick() {
        _uiState.update { it.copy(showDialog = true) }
    }

    fun removeAddictionPopup() {
        _uiState.update { it.copy(showDialog = false) }
    }

    var addictionDailyRecordUiState by mutableStateOf(AddictionDailyRecordUiState())

    fun updateAddictionUiState(addictionDetails: AddictionDetails) {
        _uiState.update { it.copy(addictionDetails = addictionDetails) }
    }



}

