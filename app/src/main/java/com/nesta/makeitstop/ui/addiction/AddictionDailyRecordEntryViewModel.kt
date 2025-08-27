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
): ViewModel() {

    suspend fun saveDailyRecord() {
        if (validateFirstInput() && validateSecondInput())
            dailyRecordRepository.insertAddictionDailyRecord(addictionDailyRecordUiState.addictionDailyRecordDetails.toAddictionDailyRecord())
    }


    var addictionDailyRecordUiState by mutableStateOf(AddictionDailyRecordUiState())

    fun updateAddictionDailyRecordUiState(addictionDailyRecordDetails: AddictionDailyRecordDetails){
        addictionDailyRecordUiState =
            AddictionDailyRecordUiState(addictionDailyRecordDetails = addictionDailyRecordDetails, isFirstEntryValid = validateFirstInput(addictionDailyRecordDetails), isSecondEntryValid = validateSecondInput(addictionDailyRecordDetails))
    }




    private fun validateFirstInput(uiState: AddictionDailyRecordDetails = addictionDailyRecordUiState.addictionDailyRecordDetails): Boolean {
        return with(uiState) {
          // addictionId > 0 &&
                    firstAnswer.isNotBlank() &&
                    secondAnswer.isNotBlank() &&
                    thirdAnswer.isNotBlank()
        }
    }

    private fun validateSecondInput(uiState: AddictionDailyRecordDetails = addictionDailyRecordUiState.addictionDailyRecordDetails): Boolean {
        return with(uiState) {
          //  addictionId > 0 &&
                    fourthAnswer.isNotBlank() &&
                    fifthAnswer.isNotBlank()
        }
    }
}

