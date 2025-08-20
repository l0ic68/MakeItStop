package com.nesta.makeitstop.ui.addiction

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

var addictionDailyRecordUiState by mutableStateOf(AddictionDailyRecordUiState())

fun updateUiState(addictionDailyRecordDetails: AddictionDailyRecordDetails){
    addictionDailyRecordUiState =
        AddictionDailyRecordUiState(addictionDailyRecordDetails = addictionDailyRecordDetails, isEntryValid = validateInput(addictionDailyRecordDetails))
}
data class AddictionDailyRecordUiState(
    val addictionDailyRecordDetails: AddictionDailyRecordDetails = AddictionDailyRecordDetails(),
    val isEntryValid: Boolean = false
)

data class AddictionDailyRecordDetails(
    val id: Int = 0,
    val addiction : String = "",
    val answers: String = "",
    val feelingScore: Int = 5,
)

private fun validateInput(uiState: AddictionDailyRecordDetails = addictionDailyRecordUiState.addictionDailyRecordDetails): Boolean {
    return with(uiState) {
        addiction.isNotBlank() && answers.isNotBlank()
    }
}
