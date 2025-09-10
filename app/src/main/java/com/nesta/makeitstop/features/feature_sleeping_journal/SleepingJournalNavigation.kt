package com.nesta.makeitstop.features.feature_sleeping_journal

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentManager
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

fun NavGraphBuilder.sleepingJournalGraph(navController : NavHostController) {
    navigation(
        route = Routes.SleepingJournaling.Graph,
        startDestination = Routes.SleepingJournaling.DashBoard
    ) {
        composable(Routes.SleepingJournaling.DashBoard) { backStackEntry ->
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
                },
                sleepingJournalUiState = viewModel.sleepingJournalUiState,
                onSleepingJournalValueChange = viewModel::updateSleepingRecordUiState,
                onBottomBarValueChange = {
                    navController.navigate(Routes.SleepingJournaling.Sleeping)
                },
                modifier = Modifier.padding(20.dp)
            )
        }

        composable(Routes.SleepingJournaling.Sleeping) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.SleepingJournaling.Graph)
            }

            SleepingJournalsScreen()
        }
    }
}