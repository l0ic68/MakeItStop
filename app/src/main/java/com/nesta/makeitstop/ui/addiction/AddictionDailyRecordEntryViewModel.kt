package com.nesta.makeitstop.ui.addiction

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nesta.makeitstop.addiction.data.Addiction
import com.nesta.makeitstop.addiction.data.AddictionRepository
import com.nesta.makeitstop.addiction.data.DailyRecord
import com.nesta.makeitstop.addiction.data.DailyRecordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import kotlin.String

data class AddictionDailyRecordUiState(
    val addictionDailyRecordDetails: AddictionDailyRecordDetails = AddictionDailyRecordDetails(),
    val isFirstEntryValid: Boolean = false,
    val isSecondEntryValid: Boolean = false
)

data class AddictionUiState(
    val addictionDetails: AddictionDetails = AddictionDetails(),
)

data class AddictionDailyRecordDetails(
    val id: Int = 0,
    val addiction : String = "",
    val addictionId : Int = 0 ,
    val firstAnswer: String = "",
    val secondAnswer: String = "",
    val thirdAnswer: String = "",
    val fourthAnswer: String = "",
    val fifthAnswer: String = "",
    val feelingScore: Float = 5f,
)

data class AddictionDetails(
    val id: Int = 0,
    val addiction : String = "",
)

fun AddictionDailyRecordDetails.toAddictionDailyRecord(): DailyRecord =
    DailyRecord(
        id = id,
        addictionId = addictionId,
        firstAnswer = firstAnswer,
        secondAnswer= secondAnswer,
        thirdAnswer = thirdAnswer,
        fourthAnswer = fourthAnswer,
        fifthAnswer = fifthAnswer,
        feelingScore = feelingScore
    )


fun AddictionDetails.toAddiction(): Addiction =
    Addiction(
        id = id,
        name = addiction
    )

class AddictionDailyRecordEntryViewModel(
    private val dailyRecordRepository: DailyRecordRepository,
    private val addictionRepository: AddictionRepository
): ViewModel() {

    suspend fun saveDailyRecord() {
        if (validateFirstInput() && validateSecondInput())
            dailyRecordRepository.insertAddictionDailyRecord(addictionDailyRecordUiState.addictionDailyRecordDetails.toAddictionDailyRecord())
    }

    val addictionList: StateFlow<List<Addiction>> =
        addictionRepository.getAllAddiction()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(50000),
                initialValue = emptyList()
            )

    suspend fun saveAddiction() {
        addictionRepository.insertAddiction(addictionUiState.addictionDetails.toAddiction())
    }

    var addictionDailyRecordUiState by mutableStateOf(AddictionDailyRecordUiState())
    var addictionUiState by mutableStateOf(AddictionUiState())

    fun updateAddictionDailyRecordUiState(addictionDailyRecordDetails: AddictionDailyRecordDetails){
        addictionDailyRecordUiState =
            AddictionDailyRecordUiState(addictionDailyRecordDetails = addictionDailyRecordDetails, isFirstEntryValid = validateFirstInput(addictionDailyRecordDetails), isSecondEntryValid = validateSecondInput(addictionDailyRecordDetails))
    }

    fun updateAddictionUiState(addictionDetails: AddictionDetails){
        addictionUiState =
            AddictionUiState(addictionDetails = addictionDetails)
    }


    private fun validateFirstInput(uiState: AddictionDailyRecordDetails = addictionDailyRecordUiState.addictionDailyRecordDetails): Boolean {
        return with(uiState) {
           addictionId > 0 &&
                    firstAnswer.isNotBlank() &&
                    secondAnswer.isNotBlank() &&
                    thirdAnswer.isNotBlank()
        }
    }

    private fun validateSecondInput(uiState: AddictionDailyRecordDetails = addictionDailyRecordUiState.addictionDailyRecordDetails): Boolean {
        return with(uiState) {
            addictionId > 0 &&
                    fourthAnswer.isNotBlank() &&
                    fifthAnswer.isNotBlank()
        }
    }
}

