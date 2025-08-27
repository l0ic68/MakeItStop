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
import com.nesta.makeitstop.ui.addiction.AddictionViewModel
import com.nesta.makeitstop.ui.addiction.CravingScreen
import com.nesta.makeitstop.ui.addiction.FeelingScreen
import com.nesta.makeitstop.ui.addiction.AddictionsScreen
import kotlinx.coroutines.launch

enum class Screen {
    OnBoardingScreen,
    FeelingScreen,
    CravingScreen
}
@Composable
fun DashboardScreen(
    viewModel: AddictionDailyRecordEntryViewModel = viewModel(factory = AppViewModelProvider.Factory),
    addictionViewModel: AddictionViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    var currentScreen by remember { mutableStateOf(Screen.OnBoardingScreen) }
    val coroutineScope = rememberCoroutineScope()
    val addictionList by addictionViewModel.addictionList.collectAsState()
    when (currentScreen) {
        Screen.CravingScreen -> CravingScreen(
            onClick = { currentScreen = Screen.FeelingScreen },
            dailyRecordUiState = viewModel.addictionDailyRecordUiState,
            onDailyRecordValueChange = viewModel::updateAddictionDailyRecordUiState,
        )
        Screen.OnBoardingScreen -> AddictionsScreen(
            modifier = Modifier,
            onClick = {
                coroutineScope.launch {
                    addictionViewModel.saveAddiction()
                    viewModel.addictionDailyRecordUiState.addictionDailyRecordDetails.copy(addiction = addictionViewModel.uiState.value.addictionDetails.addiction)
                    viewModel.addictionDailyRecordUiState.addictionDailyRecordDetails.copy(addictionId = addictionViewModel.uiState.value.addictionDetails.id)
                }

                currentScreen = Screen.CravingScreen
            },
            addictionUiState = addictionViewModel.uiState.collectAsState(),
            onAddAddiction = addictionViewModel::updateAddictionUiState,
            onAddAddictionClick = addictionViewModel::addAddictionClick,
            addictionList = addictionList
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