package com.nesta.makeitstop.features.feature_addiction

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.nesta.makeitstop.Screen
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionDailyRecordEntryViewModel
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionViewModel
import com.nesta.makeitstop.features.feature_addiction.ui.AddictionsScreen
import com.nesta.makeitstop.features.feature_addiction.ui.CravingScreen
import com.nesta.makeitstop.features.feature_addiction.ui.FeelingScreen
import com.nesta.makeitstop.features.feature_tutorial.OnBoardingScreen
import com.nesta.makeitstop.navigation.Routes
import com.nesta.makeitstop.ui.AppViewModelProvider
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

fun NavGraphBuilder.addictionGraph(navController: NavHostController) {
    navigation(
        route = Routes.Addiction.Graph,
        startDestination = Routes.Addiction.DashBoard
    ) {
        composable(route = Routes.Addiction.Craving) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Addiction.Graph)
            }
            val viewModel: AddictionDailyRecordEntryViewModel =
                viewModel(parentEntry, factory = AppViewModelProvider.Factory)

            CravingScreen(
                onClick = { navController.navigate(Routes.Addiction.Post) },
                dailyRecordUiState = viewModel.addictionDailyRecordUiState,
                onDailyRecordValueChange = viewModel::updateAddictionDailyRecordUiState
            )
        }
        composable(route = Routes.Addiction.DashBoard) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Addiction.Graph)
            }
            val viewModel: AddictionDailyRecordEntryViewModel =
                viewModel(parentEntry, factory = AppViewModelProvider.Factory)
            val addictionViewModel: AddictionViewModel =
                viewModel(parentEntry, factory = AppViewModelProvider.Factory)
            val coroutineScope = rememberCoroutineScope()
            val addictionList by addictionViewModel.addictionList.collectAsState()

            AddictionsScreen(
                modifier = Modifier,
                onClick = {
                    coroutineScope.launch {
                        val addictionId = addictionViewModel.saveAddiction()
                        viewModel.updateAddictionDailyRecordUiState(
                            viewModel.addictionDailyRecordUiState.addictionDailyRecordDetails.copy(
                                addiction = addictionViewModel.uiState.value.addictionDetails.addiction,
                                addictionId = addictionId
                            )
                        )
                        addictionViewModel.removeAddictionPopup()
                    }
                    navController.navigate(Routes.Addiction.Craving)
                },
                addictionUiState = addictionViewModel.uiState.collectAsState(),
                onAddAddiction = addictionViewModel::updateAddictionUiState,
                onAddAddictionClick = addictionViewModel::addAddictionClick,
                addictionList = addictionList
            )
        }

        composable(route = Routes.Addiction.Post) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Addiction.Graph)
            }

            val viewModel: AddictionDailyRecordEntryViewModel =
                viewModel(parentEntry, factory = AppViewModelProvider.Factory)
            val coroutineScope = rememberCoroutineScope()

            FeelingScreen(
                dailyRecordUiState = viewModel.addictionDailyRecordUiState,
                onDailyRecordValueChange = viewModel::updateAddictionDailyRecordUiState,
                onSaveClick = {
                    coroutineScope.launch {
                        viewModel.saveDailyRecord()
                    }
                    navController.navigate(Routes.Addiction.DashBoard)
                }
            )
        }
    }
}