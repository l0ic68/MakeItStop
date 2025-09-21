package com.nesta.makeitstop.features.feature_sleeping_journal

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel.SleepingJournalRecordViewModel
import com.nesta.makeitstop.features.feature_sleeping_journal.ui.SleepingJournalScreen
import com.nesta.makeitstop.features.feature_sleeping_journal.ui.SleepingJournalsScreen
import com.nesta.makeitstop.navigation.Routes
import com.nesta.makeitstop.ui.AppViewModelProvider
import kotlinx.coroutines.launch


enum class Tab {
    Sleeping,
    Dashboard
}
fun NavGraphBuilder.sleepingJournalGraph(navController : NavHostController) {
    navigation(
        route = Routes.SleepingJournaling.Graph,
        startDestination = Routes.SleepingJournaling.Sleeping
    ) {
        var currentTab = Tab.Sleeping
        composable(Routes.SleepingJournaling.Sleeping) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.SleepingJournaling.Graph)
            }
            val viewModel: SleepingJournalRecordViewModel =
                viewModel(parentEntry, factory = AppViewModelProvider.Factory)

            val coroutineScope = rememberCoroutineScope()
            SleepingJournalScreen(
                onClick = {
                    coroutineScope.launch {
                        viewModel.saveSleepingJournal()
                    }
                    currentTab = Tab.Dashboard

                    navController.navigate(Routes.SleepingJournaling.DashBoard)
                },
                sleepingJournalUiState = viewModel.sleepingJournalUiState,
                onSleepingJournalValueChange = viewModel::updateSleepingRecordUiState,
                onTabSelected = { tab ->
                    if (currentTab != tab) {
                        currentTab = tab

                        when(tab) {
                            Tab.Sleeping ->
                                navController.navigate(Routes.SleepingJournaling.Sleeping)
                            Tab.Dashboard -> navController.navigate(Routes.SleepingJournaling.DashBoard)
                        }

                    }
                },
                currentTab = Tab.Sleeping,
                modifier = Modifier.padding(20.dp)

            )
        }

        composable(Routes.SleepingJournaling.DashBoard) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.SleepingJournaling.Graph)
            }
            val recordsViewModel: SleepingJournalRecordViewModel =
                viewModel(parentEntry, factory = AppViewModelProvider.Factory)

            val recordsList by recordsViewModel.recordsList.collectAsState()
            val coroutineScope = rememberCoroutineScope()


            SleepingJournalsScreen(
                onTabSelected = { tab ->
                    if (currentTab != tab) {
                        currentTab = tab

                        when(tab) {
                            Tab.Sleeping ->
                                navController.navigate(Routes.SleepingJournaling.Sleeping)
                            Tab.Dashboard -> navController.navigate(Routes.SleepingJournaling.DashBoard)
                        }

                    }
                },
                currentTab = Tab.Dashboard,
                recordList = recordsList,
                onDelete = {
                    coroutineScope.launch {
                        recordsViewModel.deleteJournal(it)
                    }
                },
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}