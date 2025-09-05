package com.nesta.makeitstop.features.feature_sleeping_journal

import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nesta.makeitstop.navigation.Routes

fun NavGraphBuilder.sleepingJournalGraph(navController : NavHostController) {
    navigation(
        route = Routes.SleepingJournaling.Graph,
        startDestination = Routes.SleepingJournaling.DashBoard
    ) {
        composable(Routes.SleepingJournaling.DashBoard) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.SleepingJournaling.Graph)
            }

        }
    }
}