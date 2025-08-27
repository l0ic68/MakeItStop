package com.nesta.makeitstop.ui.addiction

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.nesta.makeitstop.addiction.data.Addiction
import com.nesta.makeitstop.addiction.data.AddictionRepository
import com.nesta.makeitstop.addiction.data.DailyRecordRepository
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

    suspend fun saveAddiction() {
        addictionRepository.insertAddiction(_uiState.value.addictionDetails.toAddiction())
    }

    fun addAddictionClick() {
        _uiState.update { it.copy(showDialog = true) }
    }

    var addictionDailyRecordUiState by mutableStateOf(AddictionDailyRecordUiState())

    fun updateAddictionUiState(addictionDetails: AddictionDetails) {
        _uiState.update { it.copy(addictionDetails = addictionDetails) }
    }



}

