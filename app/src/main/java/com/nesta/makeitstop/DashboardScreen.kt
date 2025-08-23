package com.nesta.makeitstop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nesta.makeitstop.ui.AppViewModelProvider
import com.nesta.makeitstop.ui.addiction.AddictionDailyRecordEntryViewModel
import com.nesta.makeitstop.ui.addiction.CravingScreen
import com.nesta.makeitstop.ui.addiction.FeelingScreen
import com.nesta.makeitstop.ui.addiction.OnBoardingScreen
import kotlinx.coroutines.launch

enum class Screen {
    OnBoardingScreen,
    FeelingScreen,
    CravingScreen
}
@Composable
fun DashboardScreen(
    viewModel: AddictionDailyRecordEntryViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var currentScreen by remember { mutableStateOf(Screen.OnBoardingScreen) }
    val coroutineScope = rememberCoroutineScope()
    val addictionUiState by viewModel.addictionList.collectAsState()
    when (currentScreen) {
        Screen.CravingScreen -> CravingScreen(
            onClick = { currentScreen = Screen.FeelingScreen },
            dailyRecordUiState = viewModel.addictionDailyRecordUiState,
            onDailyRecordValueChange = viewModel::updateAddictionDailyRecordUiState,
        )
        Screen.OnBoardingScreen -> OnBoardingScreen(
            modifier = Modifier,
            onClick = {
                coroutineScope.launch {
                    viewModel.saveAddiction()
                    viewModel.addictionDailyRecordUiState.addictionDailyRecordDetails.copy(addiction = viewModel.addictionUiState.addictionDetails.addiction)
                    viewModel.addictionDailyRecordUiState.addictionDailyRecordDetails.copy(addictionId = viewModel.addictionUiState.addictionDetails.id)
                }

                currentScreen = Screen.CravingScreen
            },
            addictionUiState = viewModel.addictionUiState,
            onAddAddiction = viewModel::updateAddictionUiState,
            addictionList = addictionUiState
        )
        Screen.FeelingScreen -> FeelingScreen(
            dailyRecordUiState = viewModel.addictionDailyRecordUiState,
            onDailyRecordValueChange = viewModel::updateAddictionDailyRecordUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.saveDailyRecord()
                }
                currentScreen = Screen.OnBoardingScreen
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}