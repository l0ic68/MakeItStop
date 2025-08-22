package com.nesta.makeitstop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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

    when (currentScreen) {
        Screen.CravingScreen -> CravingScreen(
            onClick = { currentScreen = Screen.FeelingScreen },
            dailyRecordUiState = viewModel.addictionDailyRecordUiState,
            onDailyRecordValueChange = viewModel::updateUiState,
        )
        Screen.OnBoardingScreen -> OnBoardingScreen(
            "J'ai envie de boire un monster",
            onClick = { currentScreen = Screen.CravingScreen })
        Screen.FeelingScreen -> FeelingScreen(
            dailyRecordUiState = viewModel.addictionDailyRecordUiState,
            onDailyRecordValueChange = viewModel::updateUiState,
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